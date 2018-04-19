package model.Actions;

import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.ArrayList;
import java.util.List;

public class Linear implements ActionType {


    /** This generate the tiles that a certain action will affect **/
    //Suggestion: make Set a List
    @Override
    public List<Tile> generateAffectedTiles(Tile tile, Direction direction, Action action) {
        int range = action.getMaxRange();
        List<Tile> affectedTiles = new ArrayList<>();

        Tile tempTile = tile;

        for(int i = 0; i < range; i++){
            affectedTiles.add(tempTile);
            tempTile = tempTile.getNeighbor(direction);
        }

        return affectedTiles;
    }


}
