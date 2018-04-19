package model.Actions;


import model.Effect.EntityEffect;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.Set;


public class EntityAction extends Action{
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
    public Set<Tile> getAffectedTiles(Tile tile, Direction direction) {
        return actionType.generateAffectedTiles(tile, direction, this);
    }
}
