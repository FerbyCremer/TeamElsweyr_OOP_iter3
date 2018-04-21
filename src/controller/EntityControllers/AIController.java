package controller.EntityControllers;

import model.Entities.Entity;
import model.Entities.Player;
import model.Items.Item;
import model.Map.Direction;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AIController {
    Player player;
    private ContentMap<Entity> entityMap;
    private ContentMap<Item> itemMap;


    public AIController(Zone zone, Player player){
        entityMap = zone.getEntityMap();
        itemMap = zone.getItemMap();
        this.player = player;
    }

    public void updateMaps(Zone zone){
        entityMap = zone.getEntityMap();
        itemMap = zone.getItemMap();
        // updateMaps(zone); //if merge conflict keep both from here and master: Recursive call on itself???
    }

    //From what??
    public ArrayList<Direction> findPathToEntity(Entity entity){
        ArrayList<Direction> map = new ArrayList<>();
        Tile targetTile = entityMap.getTileOf(player);
        Tile from  = entityMap.getTileOf(entity);

        return recursiveBFS(new ArrayList<Direction>(), new HashSet<Tile>(), targetTile, from, entity.getDirection());


    }

    private ArrayList<Direction> recursiveBFS(ArrayList<Direction> currentPath, Set<Tile> visited, Tile target, Tile current, Direction direction){
        //need to add if current null
        if(current == target){
            currentPath.add(direction);
            return currentPath;
        }
        else if (visited.contains(current)){
            return null;
        }
        else if (current != target){
            //add to visited
            visited.add(current);
            currentPath.add(direction);
            //shortest of 6 paths, if they exists
            ArrayList<ArrayList<Direction>> possiblePaths = new ArrayList<>();
            for(int i = 0; i < 6; i++) {
                 possiblePaths.add(recursiveBFS(currentPath, visited, target, current.getNeighbor(direction.getClockwise(i*60)), direction.getClockwise(i*60)));
            }
            return shortestOf(possiblePaths);
        }
        return null;
    }

    private ArrayList<Direction> shortestOf(List<ArrayList<Direction>> directions){
        ArrayList<Direction> shortestList = new ArrayList<>();
        int shortest = 10000;
        for(int i = 0; i < directions.size(); i++ ){
            if(directions.get(i) != null) {
                if (directions.get(i).size() < shortest) {
                    shortest = directions.get(i).size();
                    shortestList = directions.get(i);
                }
            }
        }
        return shortestList;
    }

    //TODO: Should this take in an Item? ya
    //From what
    public ArrayList<Direction> findPathToItem(Entity entity){
        //Should find a random item on map (NULL check)
        Tile targetTile = itemMap.getRandomTileWithContent();
        return recursiveBFS(new ArrayList<Direction>(), new HashSet<Tile>(), targetTile, entityMap.getTileOf(entity), player.getDirection());
    }

    //these methods don't give me enough information, from what?
    public ArrayList<Direction> findPathToPlayer(Entity entity){
        return recursiveBFS(new ArrayList<Direction>(), new HashSet<Tile>(), entityMap.getTileOf(player), entityMap.getTileOf(entity),  player.getDirection());
    }

}
