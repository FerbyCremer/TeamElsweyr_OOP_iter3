package model.Map.Zone;

import model.Items.Item;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.HashMap;
import java.util.Set;
import java.util.Timer;

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
