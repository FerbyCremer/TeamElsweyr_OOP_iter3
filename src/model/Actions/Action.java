package model.Actions;

import model.Actions.ActionType.ActionType;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.Set;

public abstract class Action {
    private int maxRange;
    private int distanceTraveled;
    private ActionType actionType;
    private int accuracy;
    public abstract Action clone(int modifier);
    public abstract Set<Tile> getAffectedTiles(Tile tile, Direction direction);
}
