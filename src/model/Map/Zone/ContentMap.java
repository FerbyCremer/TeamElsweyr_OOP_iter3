package model.Map.Zone;


import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ContentMap<T> {
    private ConcurrentHashMap<Tile, T> map;

    public ContentMap() {
        this.map = new ConcurrentHashMap<>();
    }

    public T getContentAtTile(Tile tile) {
        return map.get(tile);
    }

    public void setContent(Tile tile, T content){
        map.put(tile, content);
    }
    
    public void setNewLocation(Tile tile, T content) {
        removeContent(content);
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

    public Tile getRandomTileWithContent() {
        List<Tile> allTilesWithContent = new ArrayList<>(map.keySet());
        if (allTilesWithContent.size() > 0){
            return allTilesWithContent.get(0);
        }
        return null;
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

    public Set<Tile> getTilesContentIsOn(){
        return map.keySet();
    }


}
