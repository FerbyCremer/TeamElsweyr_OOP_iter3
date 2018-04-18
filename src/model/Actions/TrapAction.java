package model.Actions;

import model.Actions.ActionType.ActionType;
import model.Effect.TrapEffects.TrapEffect;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.Set;

public class TrapAction extends Action{
    private int maxRange;
    private int distanceTraveled;
    private ActionType actionType;
    private int accuracy;
    TrapEffect trapEffect;

    public TrapAction(int maxRange, int distanceTraveled, int accuracy, TrapEffect trapEffect) {
        this.maxRange = maxRange;
        this.distanceTraveled = distanceTraveled;
        this.accuracy = accuracy;
    }

    @Override
    public Action clone(int modifier) {
        Action action = new TrapAction(this.maxRange,this.accuracy*modifier,1+this.distanceTraveled, this.trapEffect);
        return action;
    }

    @Override
    public Set<Tile> getAffectedTiles(Tile tile, Direction direction) {
        return actionType.generateAffectedTiles(tile, direction, this);
    }
}
