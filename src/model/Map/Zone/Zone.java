package model.Map.Zone;

import model.Entities.Entity;
import model.Items.Item;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Vector;

public class Zone {

    private String id;
    private Tile[][] tiles;
    private ContentMap<Decal> decalMap;
    private ContentMap<Entity> entityMap;
    private ContentMap<Item> itemMap;
    private ContentMap<AreaEffect> areaEffectMap;
    private ContentMap<Trap> trapMap;
    private ContentMap<River> riverMap;
    private Point spawnPoint;

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


    public Item getItemFromTile(Tile tile){
        return itemMap.getContentAtTile(tile);
    }

    public Tile getTileForItem(Item item){
        return itemMap.getTileOf(item);
    }


    public HashMap<Direction, Tile> computeNeighbors(Tile tile){
        return tile.getNeighbors();
    }

    public String getID() {
        return id;
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
}
