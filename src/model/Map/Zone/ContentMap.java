package model.Map.Zone;


import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
