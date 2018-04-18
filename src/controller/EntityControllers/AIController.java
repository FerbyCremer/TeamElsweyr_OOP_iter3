package controller.EntityControllers;

import model.Entities.Entity;
import model.Entities.Player;
import model.Items.Item;
import model.Map.Direction;
import model.Map.Zone.ContentMap;
import model.Map.Zone.Zone;

import java.util.ArrayList;

public class AIController {
    Player player;
    private ContentMap<Entity> entityMap;
    private ContentMap<Item> itemMap;

    public AIController(Zone zone){}

    public void updateMaps(Zone zone){}

    public ArrayList<Direction> findPathToEntity(Entity entity){
        return null;
    }

    //TODO: Should this take in an Item?
    public ArrayList<Direction> findPathToItem(Entity entity){
        return null;
    }

    public ArrayList<Direction> findPathToPlayer(Player player){
        return null;
    }

}
