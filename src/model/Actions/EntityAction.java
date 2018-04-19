package model.Actions;


import model.Actions.ActionType.ActionType;
import model.Actions.ActionType.ActionType.ActionType;
import model.Effect.EntityEffect.EntityEffect;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.HashMap;


public class EntityAction extends Action{
    private int maxRange;
    private int distanceTraveled;
    private ActionType actionType;
    private int accuracy;
    EntityEffect entityEffect;

    public EntityAction(int maxRange, int distanceTraveled, int accuracy, EntityEffect entityEffect) {
        this.maxRange = maxRange;
        this.distanceTraveled = distanceTraveled;
        this.accuracy = accuracy;
    }

    @Override
    public Action clone(int modifier) {
        Action action = new EntityAction(this.maxRange,this.accuracy*modifier,1+this.distanceTraveled, this.entityEffect);
        return action;
    }

    @Override
    public HashMap<Tile, Integer> getAffectedTiles(Tile tile, Direction direction) {
        return actionType.generateAffectedTiles(tile, direction, this);
    }
}
