package model.Actions.ActionType;

import controller.LoadGame.SaveVisitor;
import model.Actions.Action;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Angular implements ActionType{

    /** This generate the tiles that a certain action will affect **/
    //Suggestion: make Set a List
    @Override
    public HashMap<Tile, Integer> generateAffectedTiles(Tile tile, Direction direction, Action action) {
        int range = action.getMaxRange();
        HashMap<Tile, Integer> affectedTiles = new HashMap<>();
        Utility utility = new Utility();
        Tile tempTile = tile;
        affectedTiles.put(tempTile, 0);
        tempTile = tempTile.getNeighbor(direction);

        for(int i = 0; i <= range; i++){
            affectedTiles.put(tempTile, i);
            List<Tile> right = getAffectedTileLinear(tempTile, direction.getClockwise(120), i);
            List<Tile> left = getAffectedTileLinear(tempTile, direction.getClockwise(-120), i);
            utility.copyFromList(affectedTiles, right, i);
            utility.copyFromList(affectedTiles, left, i);
            tempTile = tempTile.getNeighbor(direction);
        }

        return affectedTiles;
    }

    //could be off by one when sent range
    private List<Tile> getAffectedTileLinear(Tile tile, Direction direction, int range){
        List<Tile> affectedTiles = new ArrayList<>();

        Tile tempTile = tile;

        for(int i = 0; i < range; i++){
            affectedTiles.add(tempTile);
            tempTile = tempTile.getNeighbor(direction);
        }

        return affectedTiles;
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return "angular";
    }


    private static class Utility<T>{
        private void copyFromList(HashMap<T, Integer> copyTo, List<T> copyFrom, Integer integer ){

            for (T element: copyFrom) {
                copyTo.put(element, integer);
            }

        }
    }

}
