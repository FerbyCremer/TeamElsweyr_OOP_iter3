package controller.LoadGame;

import model.Effect.TrapEffects.TrapEffect;
import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Entity;
import model.Entities.NPC.NPC;
import model.Entities.Pet;
import model.Entities.Player;
import model.Inventory.Inventory;
import model.Items.OneShot.OneShot;
import model.Items.Takeable.Armor;
import model.Items.Takeable.Consumable;
import model.Items.Takeable.Ring;
import model.Items.Takeable.Tool;
import model.Map.Terrain;
import model.Map.World;
import model.Map.Zone.TileRelatedClasses.*;
import model.Map.Zone.Zone;

public interface SaveVisitor {
    String saveWorld(World world);

    String saveZone(Zone zone);

    String saveTile(Tile tile);

    String saveEntity(Entity entity);

    String saveNPC(NPC npc);

    String savePlayer(Player player);

    String savePet(Pet pet);

    String saveInventory(Inventory  inventory);

    String saveRiver(River river);

    String saveTerrain(Terrain terrain);

    String saveDecal(Decal decal);

    String saveAreaEffect(AreaEffect areaEffect);

    String saveTool(Tool tool);

    String saveArmor(Armor armor);

    String saveRing(Ring ring);

    String saveConsumable(Consumable consumable);

    String saveOneShot(OneShot oneShot);

    String saveTrap(Trap trap);

    String saveEntityEffect(EntityEffect entityEffect);

    String saveTrapEffect(TrapEffect trapEffect);

}
