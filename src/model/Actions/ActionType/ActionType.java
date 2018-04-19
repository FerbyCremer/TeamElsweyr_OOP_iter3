package model.Actions.ActionType;

import model.Actions.Action;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface ActionType {
    public HashMap<Tile, Integer> generateAffectedTiles(Tile tile, Direction direction, Action action);
}
