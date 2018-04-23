package model.Actions.ActionType;

import controller.LoadGame.SaveVisitor;
import model.Actions.Action;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.*;

public class Radial implements ActionType{

    /** This generate the tiles that a certain action will affect **/
    //Suggestion: make Set a List
    @Override
    public HashMap<Tile, Integer> generateAffectedTiles(Tile tile, Direction direction, Action action) {
        int range = action.getMaxRange();
        HashMap<Tile, Integer> affectedTiles = new HashMap<>();
        Utility utility = new Utility();
        if(range == 0){
            affectedTiles.put(tile, 1);
            return affectedTiles;
        }
        tile  = tile.getNeighbor(direction);
        for(int i = 1; i <= range; i++){
            if(tile != null) {
                utility.copyFromList(affectedTiles, generateCircle(direction, tile, i), i);
                tile = tile.getNeighbor(direction);
            }
        }
        return affectedTiles;
    }

    //might be buggy
    private List<Tile> generateCircle(Direction direction, Tile tile, int radius ){
        List<Tile> tileList = new ArrayList<>();
        Direction tempDirection = direction;
        Tile tempTile = tile;
        tempDirection=tempDirection.getClockwise(120);
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < radius; j++){
                if(tempTile != null) {
                    tileList.add(tempTile);
                    tempTile = tempTile.getNeighbor(tempDirection);
                }
            }
            tempDirection = tempDirection.getClockwise(60);
        }
        return tileList;
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return "radial";
    }


    private static class Utility<T>{
        private void copyFromList(HashMap<T, Integer> copyTo, List<T> copyFrom, Integer integer ){

            for (T element: copyFrom) {
                copyTo.put(element, integer);
            }

        }
    }
}
