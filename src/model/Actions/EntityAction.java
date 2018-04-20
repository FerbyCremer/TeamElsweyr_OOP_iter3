package model.Actions;


import controller.Handlers.ActionHandler;
import model.Actions.ActionType.ActionType;
import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Entity;
import model.Entities.Player;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.HashMap;


public class EntityAction extends Action{
    private int maxRange;
    private ActionType actionType;
    private int accuracy;
    EntityEffect entityEffect;

    public EntityAction(int maxRange, int accuracy, EntityEffect entityEffect) {
        this.maxRange = maxRange;
        this.accuracy = accuracy;
        this.entityEffect = entityEffect;
    }

    @Override
    public Action clone(double modifier) {
        int modifiedAccuracy =  (int) (this.accuracy * modifier);
        Action action = new EntityAction(this.maxRange, modifiedAccuracy, this.entityEffect);
        return action;
    }

    @Override
    public HashMap<Tile, Integer> getAffectedTiles(Tile tile, Direction direction) {
        return actionType.generateAffectedTiles(tile, direction, this);
    }

    @Override
    public void createInstanceFor(ActionHandler actionHandler, Player player) {
        actionHandler.createAction(player, this);

    }

    public void apply(Entity entity, int distance){
        if(distance * accuracy > 1) {
            entityEffect.apply(entity);
        }
        else {
            //miss
        }
    }
}
