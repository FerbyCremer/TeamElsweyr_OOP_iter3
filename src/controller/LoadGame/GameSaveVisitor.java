package controller.LoadGame;

import model.Effect.EntityEffect.EntityEffect;
import model.Effect.TrapEffects.TrapEffect;
import model.Entities.*;
import model.Entities.NPC.NPC;
import model.Inventory.Equipment;
import model.Inventory.Inventory;
import model.Items.Item;
import model.Items.OneShot.OneShot;
import model.Items.Takeable.*;
import model.Map.Terrain;
import model.Map.World;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.*;
import model.Map.Zone.Zone;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class GameSaveVisitor implements SaveVisitor{

    @Override
    public String saveWorld(World world) {
        String saveFile = "world\n";

        List<Zone> zones = world.getZones();
        for (Zone z: zones) {
            saveFile+= z.accept(this);
        }
        saveFile+="endZone\n";
        saveFile+=world.getCurrentZoneID() + "\n";
        saveFile += "endOfWorld";
        return saveFile;
    }

    @Override
    public String saveZone(Zone zone) {
        String save = "zone\n";
        Tile[][] tiles = zone.getTiles();
        save += zone.getID() + "\n";
        save += saveCoordinate(zone.getSpawnPoint());
        save += tiles.length + "\n"; //TODO might need to check this
        save += tiles[0].length + "\n";

        //Tiles
        for (int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length ; j++){
                save += saveTile(tiles[i][j]);
                save += saveCoordinate(tiles[i][j].getCoordinate());
            }
        }

        save+="endTile\n";

        //EntityMap
        Set<Tile> tileSet = zone.getEntityMap().getTilesContentIsOn();
        for (Tile t: tileSet) {
            save+="entityMap\n";
            save += saveCoordinate(t.getCoordinate());
            Entity e = zone.getEntityMap().getContentAtTile(t);
            save += e.accept(this);
        }

        save+="endOfEntityMap\n";

        //AreaEffectMap
        tileSet = zone.getAreaEffectMap().getTilesContentIsOn();
        for (Tile t: tileSet) {
            save+="areaEffectMap\n";
            save += saveCoordinate(t.getCoordinate());
            AreaEffect a = zone.getAreaEffectMap().getContentAtTile(t);
            save += a.accept(this);
            save += "endOfEffect\n";
        }
        save+="endOfAreaEffectMap\n";

        //RiverMap
        tileSet = zone.getRiverMap().getTilesContentIsOn();
        for (Tile t: tileSet) {
            save+="riverMap\n";
            save += saveCoordinate(t.getCoordinate());
            River r = zone.getRiverMap().getContentAtTile(t);
            save += r.accept(this);
        }

        save+="endOfRiverMap\n";

        //TrapMap
        tileSet = zone.getTrapMap().getTilesContentIsOn();
        for (Tile t: tileSet) {
            save+="trapMap\n";
            save += saveCoordinate(t.getCoordinate());
            Trap tr = zone.getTrapMap().getContentAtTile(t);
            save += tr.accept(this);
            save += "endOfEffect\n";
        }

        save+="endOfTrapMap\n";

        //DecalMap
        tileSet = zone.getDecalMap().getTilesContentIsOn();
        for (Tile t: tileSet) {
            save+="decalMap\n";
            save += saveCoordinate(t.getCoordinate());
            Decal d = zone.getDecalMap().getContentAtTile(t);
            save += d.accept(this);
        }

        save+="endOfDecalMap\n";

        return save;
    }

    @Override
    public String saveTile(Tile tile) {
        String save = "tile\n";
        save += tile.getTerrainName() + "\n";
        save += tile.isObstacle() + "\n";
        return save;
    }

    @Override
    public String saveEntity(Entity entity) {
        String save = "";

        save += saveEntityStats(entity.getStats());
        save += entity.getInventory().accept(this);
        save += savePassable(entity.getTerrains());

        return save;
    }

    private String saveEntityStats(EntityStats stats){
        String save = "entityStats\n";
        save += stats.getMaxHealth() + "\n";
        save += stats.getCurrentHealth() + "\n";
        save += stats.getLevel() + "\n";
        save += stats.getExperience() + "\n";
        save += stats.getDefense() + "\n";
        save += stats.getDetectRange() + "\n";
        save += stats.getCurrentSpeed() + "\n";
        return save;
    }



    private String savePassable(List<Terrain> terrains){
        String save = "passable\n";

        for (int i = 0; i < terrains.size(); i++) {
            save += terrains.get(i).getName() + "\n";
        }

        save += "endOfPassable\n";
        return save;
    }

    @Override
    public String saveNPC(NPC npc) {
        String save = "";
        save += saveEntity(npc);
        save += "npc";
        save += npc.getNpcState().accept(this);
        save += "endOfEntityType\n";
        return save;
    }

    @Override
    public String savePlayer(Player player) {
        String save = "";
        save += saveEntity(player);
        save += "player\n";
        save += player.getName()+"\n";
        List<Skill> skills = player.getSkills();
        for (int i = 0; i < skills.size(); i++) {
            save += skills.get(i).getLevel() + "\n";
        }
        save += "endOfSkill\n";
        save += "endOfEntityType\n";
        return save;
    }

    @Override
    public String savePet(Pet pet) {
        String save = "";
        save += saveEntity(pet);
        save += "pet\n";
        save += "endOfEntityType\n";
        return save;
    }

    @Override
    public String saveInventory(Inventory inventory) {
        String save = "inventory\n";
        save+= inventory.getWealth() + "\n";
        List<Takeable> takeables = inventory.getItems();
        System.out.println("Inventory length = " + takeables.size()) ;
        for (int i = 0; i < takeables.size(); i++) {
            save += "item\n";
            save += takeables.get(i).getName()+"\n";
            save += "takeable\n";
            save += takeables.get(i).isEquipped()+"\n";
            save += takeables.get(i).accept(this); //need help with this
            save += "endOfTakeable\n";
        }
        save += "endOfInventory\n";
        return save;
    }

    @Override
    public String saveRiver(River river) {
        String save = "";
        save+= river.getDirection().getAngle() + "\n";
        save += river.getFlowRate() + "\n";
        return save;
    }

    @Override
    public String saveTerrain(Terrain terrain) {
        String save = "";
        return null;
    }

    @Override
    public String saveDecal(Decal decal) {
        String save = "";
        save += decal.getDecal() + "\n";
        return save;
    }

    @Override
    public String saveAreaEffect(AreaEffect areaEffect) {
        String save = "";
        save += areaEffect.getEffect().accept(this);
        return save;
    }

    @Override
    public String saveTool(Tool tool) {
        String save = "";
        save += "tool\n";
        save += tool.getSkill().getName() + "\n";
        save += tool.getCooldown() + "\n";
        save += tool.getAction().accept(this) + "\n"; //entityaction or trap
        save += tool.getAction().getMaxRange() + "\n";
        save += tool.getAction().getAccuracy() + "\n";
        save += tool.getAction().getActionType().accept(this) + "\n";// linear, radial
        save += tool.getAction().getEffectName() + "\n"; //find out if entity effect = amount //if not = nothing
        return save;
    }

    @Override
    public String saveArmor(Armor armor) {
        String save = "";
        save += armor.getDefense() + "\n";
        save += "armor" +"\n";
        return save;

    }

    @Override
    public String saveRing(Ring ring) {
        String save = "";
        save += "ring"+ "\n";
        return save;
    }

    @Override
    public String saveConsumable(Consumable consumable) {
        String save = "";
        save += "consumable\n";
        save += consumable.getEffect().getName() + "\n";
        return save;
    }

    @Override
    public String saveOneShot(OneShot oneShot) {
        String save = "";
        save += oneShot.getEffect().accept(this);//anything else?
        return save;
    }

    @Override
    public String saveTrap(Trap trap) {
        String save = "";
        save += trap.isVisible() + "\n";
        save += trap.isActive() + "\n";
        save += trap.getEffect().accept(this);
        return save;
    }

    @Override
    public String saveEntityEffect(EntityEffect entityEffect) {
        return "";
    }

    @Override
    public String saveTrapEffect(TrapEffect trapEffect) {
        return "";
    }

    private String saveCoordinate(Point point){
        String save = "";
        save += point.x + "\n";
        save += point.y + "\n";
        return save;
    }

}
