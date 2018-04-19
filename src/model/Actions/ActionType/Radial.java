package model.Actions.ActionType;

import model.Actions.Action;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.Set;

public class Radial implements ActionType {
    @Override
    public Set<Tile> generateAffectedTiles(Tile tile, Direction direction, Action action) {
        return null;
    }
}
