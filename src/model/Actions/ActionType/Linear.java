package model.Actions.ActionType;

import controller.LoadGame.SaveVisitor;
import model.Actions.Action;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.*;

public class Linear implements ActionType {


    /** This generate the tiles that a certain action will affect **/
    //Suggestion: make Set a List
    @Override
    public HashMap<Tile, Integer> generateAffectedTiles(Tile tile, Direction direction, Action action) {
        int range = action.getMaxRange();
        HashMap<Tile, Integer> affectedTiles = new HashMap<>();

        Tile tempTile = tile;

        for(int i = 0; i < range; i++){
            affectedTiles.put(tempTile, i);
            tempTile = tempTile.getNeighbor(direction);
        }

        return affectedTiles;
    }


    @Override
    public String accept(SaveVisitor saveVisitor) {
        return "linear";
    }
}
