package controller.EntityControllers;

import model.Entities.AI;
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

    private List<AI> allAIs;
    private List<AI> currentAIs;


    public AIController(){
        allAIs = new ArrayList<>();
        currentAIs = new ArrayList<>();
    }

    public AIController(Zone zone, Player player){
        entityMap = zone.getEntityMap();
        itemMap = zone.getItemMap();
        this.player = player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addAI(AI ai){ allAIs.add(ai); }

    public void removeEntity(Entity entity){
        for (AI ai : allAIs){
            if (ai == entity){
                allAIs.remove(ai);
            }
        }
    }

    public void updateMaps(Zone zone){
        entityMap = zone.getEntityMap();
        itemMap = zone.getItemMap();
        updateCurrentAIs();
    }

    private void updateCurrentAIs(){
        currentAIs.clear();
        Set<Tile> tiles =  entityMap.getTilesContentIsOn();
        for (Tile tile : tiles){
            for (AI ai : allAIs){
                if (ai ==   entityMap.getContentAtTile(tile)){
                    currentAIs.add(ai);
                }
            }
        }
    }

    public void makeAIDecision(){
            for(AI ai : currentAIs){
                ai.move();
            }
    }



    public ArrayList<Direction> findPathToEntity(Entity entity, Entity to){
        ArrayList<Direction> map = new ArrayList<>();
        Tile from  = entityMap.getTileOf(entity);
        Tile targetTile = entityMap.getTileOf(to);
        return recursiveBFS(new ArrayList<Direction>(), new HashSet<Tile>(), targetTile, from, entity.getDirection());
    }

    private ArrayList<Direction> recursiveBFS(ArrayList<Direction> currentPath, Set<Tile> visited, Tile target, Tile current, Direction direction){
        //need to add if current null
        if(current == null){
            return null;
        }
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
            ArrayList<ArrayList<Direction>> possiblePaths = new ArrayList<ArrayList<Direction>>();
            for(int i = 0; i < 6; i++) {
                ArrayList<Direction> path = recursiveBFS(currentPath, visited, target, current.getNeighbor(direction.getClockwise(i*60)), direction.getClockwise(i*60));
                if(path != null) {
                    possiblePaths.add(path);
                }
            }
            return shortestOf(possiblePaths);
        }
        return null;
    }

    private ArrayList<Direction> shortestOf(List<ArrayList<Direction>> directions){
        ArrayList<Direction> shortestList = new ArrayList<>();
        int shortest = 100000;
        for(int i = 0; i < directions.size(); i++ ){
            if (directions.get(i).size() < shortest) {
                shortest = directions.get(i).size();
                shortestList = directions.get(i);
            }
        }
        return shortestList;
    }

    public ArrayList<Direction> findPathToItem(Entity entity){
        //Should find a random item on map (NULL check)
        Tile targetTile = itemMap.getRandomTileWithContent();
        return recursiveBFS(new ArrayList<Direction>(), new HashSet<Tile>(), targetTile, entityMap.getTileOf(entity), player.getDirection());
    }

    private ArrayList<Direction> findPathToPlayer(Entity entity){
        return recursiveBFS(new ArrayList<Direction>(), new HashSet<Tile>(), entityMap.getTileOf(player), entityMap.getTileOf(entity),  player.getDirection());
    }

    public void movePet(AI ai){
        ArrayList<Direction> temp = findPathToPlayer(ai);
        if(temp.size() > 5)
            ai.move(findPathToPlayer(ai).get(0));
        else if(temp.size() < 5 && !temp.isEmpty())
            ai.move(findPathToItem(ai).get(0));
    }

    public void moveToPlayer(AI ai){
        ArrayList<Direction> temp = findPathToPlayer(ai);
        if(!temp.isEmpty())
            ai.move(findPathToPlayer(ai).get(0));
    }
}
