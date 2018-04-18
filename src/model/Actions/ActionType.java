package model.Actions;

import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.List;
import java.util.Set;

public interface ActionType {
    public List<Tile> generateAffectedTiles(Tile tile, Direction direction, Action action);
}
