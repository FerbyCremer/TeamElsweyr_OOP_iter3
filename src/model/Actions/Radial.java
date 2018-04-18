package model.Actions;

import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.ArrayList;
import java.util.List;

public class Radial implements ActionType{

    /** This generate the tiles that a certain action will affect **/
    //Suggestion: make Set a List
    @Override
    public List<Tile> generateAffectedTiles(Tile tile, Direction direction, Action action) {
        int range = action.getMaxRange();
        List<Tile> affectedTiles = new ArrayList<>();
        Utility utility = new Utility();
        for(int i = 0; i < range; i++){
            affectedTiles.add(tile.getNeighbor(direction));
            List<Tile> right = getAffectedTileLinear(tile, direction.getClockwise(60), i);
            List<Tile> left = getAffectedTileLinear(tile, direction.getClockwise(-60), i);
            utility.copyFromList(affectedTiles, right);
            utility.copyFromList(affectedTiles, left);
        }

        return affectedTiles;
    }

    private List<Tile> getAffectedTileLinear(Tile tile, Direction direction, int range){
        List<Tile> affectedTiles = new ArrayList<>();

        for(int i = 0; i < range; i++){

            affectedTiles.add(tile.getNeighbor(direction));
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
