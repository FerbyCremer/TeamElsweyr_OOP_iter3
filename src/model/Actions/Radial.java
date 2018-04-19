package model.Actions;

import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Radial implements ActionType{

    /** This generate the tiles that a certain action will affect **/
    //Suggestion: make Set a List
    @Override
    public List<Tile> generateAffectedTiles(Tile tile, Direction direction, Action action) {
        int range = action.getMaxRange();
        List<Tile> affectedTiles = new ArrayList<>();

        for(int i = 0; i < range; i++){
            affectedTiles.addAll(generateCircle(direction,tile,i));
        }

        return affectedTiles;
    }

    //might be buggy
    List<Tile> generateCircle(Direction direction, Tile tile, int radius ){
        List<Tile> tileList = new ArrayList<>();
        Direction tempDirection = direction;
        Tile tempTile = tile;

        tempDirection=tempDirection.getClockwise(120);
        for(int i =0; i < 6; i++){
            for(int j = 0; j < radius; j++){
                tileList.add(tempTile);
                tempTile = tempTile.getNeighbor(tempDirection);
            }
            tempDirection = tempDirection.getClockwise(60);
        }
        return tileList;
    }
}
