package model.Actions;

import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.ArrayList;
import java.util.List;

public class Angular implements ActionType{

    /** This generate the tiles that a certain action will affect **/
    //Suggestion: make Set a List
    @Override
    public List<Tile> generateAffectedTiles(Tile tile, Direction direction, Action action) {
        int range = action.getMaxRange();
        List<Tile> affectedTiles = new ArrayList<>();
        Utility utility = new Utility();
        Tile tempTile = tile;
        affectedTiles.add(tempTile);
        tempTile = tempTile.getNeighbor(direction);

        for(int i = 1; i < range; i++){
            affectedTiles.add(tempTile);
            List<Tile> right = getAffectedTileLinear(tempTile, direction.getClockwise(120), i);
            List<Tile> left = getAffectedTileLinear(tempTile, direction.getClockwise(-120), i);
            utility.copyFromList(affectedTiles, right);
            utility.copyFromList(affectedTiles, left);
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


    private static class Utility<T>{
        private void copyFromList(List<T> copyTo, List<T> copyFrom){

            for (T element: copyFrom) {
                copyTo.add(element);
            }

        }
    }

}
