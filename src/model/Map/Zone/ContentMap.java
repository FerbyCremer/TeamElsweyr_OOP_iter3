package model.Map.Zone;


import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.HashMap;
import java.util.Set;

public class ContentMap<T> {
    private HashMap<Tile, T> map;

    public ContentMap(HashMap<Tile, T> map) {
        this.map = map;
    }

    public T getContentAtTile(Tile tile) {
        return map.get(tile);
    }

    public void setContent(Tile tile, T content){
        map.put(tile, content);
    }
    
    public void setNewLocation(Tile tile, T content) {
    	Tile contentTile = getTileOf(content);
    	
    	removeContent(contentTile);
    	setContent(tile, content);
    }

    public void removeContent(Tile tile){
        map.remove(tile);
    }

    public void removeContent(T content){
        removeContent(getTileOf(content));
    }

    public boolean hasTile(Tile tile){
        return map.containsKey(tile);
    }

    //TODO: Temporary method implementation, fix
    public Tile getTileOf(T item) {
        Set<Tile> keys = map.keySet();
        for(Tile t: keys) {
            if (map.get(t).equals(item))
                return t;
        }
        return null;

    }


}
