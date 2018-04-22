package model.Map.Zone;

import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;
import model.Entities.Entity;
import model.Items.Item;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Vector;

public class Zone implements Saveable{

    private String id;
    private Tile[][] tiles;
    private ContentMap<Decal> decalMap;
    private ContentMap<Entity> entityMap;
    private ContentMap<Item> itemMap;
    private ContentMap<AreaEffect> areaEffectMap;
    private ContentMap<Trap> trapMap;
    private ContentMap<River> riverMap;
    private Point spawnPoint;

    //TODO take mapsl out of constructors and make them getters and setters
    public Zone(String id, Tile[][] tiles, ContentMap<Decal> decalMap, ContentMap<Entity> entityMap, ContentMap<Item> itemMap, ContentMap<AreaEffect> areaEffectMap, ContentMap<Trap> trapMap, ContentMap<River> riverMap, Point spawnPoint) {
        this.id = id;
        this.tiles = tiles;
        this.decalMap = decalMap;
        this.entityMap = entityMap;
        this.itemMap = itemMap;
        this.areaEffectMap = areaEffectMap;
        this.trapMap = trapMap;
        this.riverMap = riverMap;
        this.spawnPoint = spawnPoint;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Item getItemFromTile(Tile tile){
        return itemMap.getContentAtTile(tile);
    }

    public Tile getTileForItem(Item item){
        return itemMap.getTileOf(item);
    }

    public Tile getTileForEntity(Entity entity){return entityMap.getTileOf(entity);}


    public HashMap<Direction, Tile> computeNeighbors(Tile tile){
        return tile.getNeighbors();
    }

    public String getID() {
        return id;
    }

    public ContentMap<Decal> getDecalMap() {
        return decalMap;
    }

    public ContentMap<Entity> getEntityMap() {
        return entityMap;
    }

    public ContentMap<Item> getItemMap() {
        return itemMap;
    }

    public ContentMap<AreaEffect> getAreaEffectMap() {
        return areaEffectMap;
    }

    public ContentMap<Trap> getTrapMap() {
        return trapMap;
    }

    public ContentMap<River> getRiverMap() {
        return riverMap;
    }

    //TODO: Fix LOD violations
    public String getDecalName(Tile tile){
        Decal temp = decalMap.getContentAtTile(tile);
        if(temp != null)
            return temp.getDecal();
        return null;
    }

    public String getRiverName(Tile tile){
        River temp = riverMap.getContentAtTile(tile);
        if(temp != null)
            return temp.getName();
        return null;
    }

    public String getTrapName(Tile tile){
        Trap temp = trapMap.getContentAtTile(tile);
        if(temp != null)
            return temp.getName();
        return null;
    }

    public String getItemName(Tile tile){
        Item temp = itemMap.getContentAtTile(tile);
        if(temp != null)
            return temp.getName();
        return null;
    }

    public String getEntityName(Tile tile){
        Entity temp = entityMap.getContentAtTile(tile);
        if(temp != null)
            return temp.getName();
        return null;
    }

    public void removeEntityFromMap(Entity entity){
        entityMap.removeContent(entity);
    }

    public void addEntityToMap(Entity entity){
        //This might need to change depending on how we implement spawnpoint
        entityMap.setContent(tiles[spawnPoint.x][spawnPoint.y], entity);
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveZone(this);
    }
}
