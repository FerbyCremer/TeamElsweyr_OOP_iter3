package model.Actions;

import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.Set;

public abstract class Action {
    protected int maxRange;
    protected int distanceTraveled;
    //protected ActionType actionType;
    protected int accuracy;
    
    public abstract Action clone(int modifier);
    public abstract Set<Tile> getAffectedTiles(Tile tile, Direction direction);
}
