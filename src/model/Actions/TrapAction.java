package model.Actions;


import controller.Handlers.ActionHandler;
import model.Actions.ActionType.ActionType;
import model.Effect.TrapEffects.TrapEffect;

//import model.Effect.TrapEffect;

import model.Entities.Entity;
import model.Entities.Player;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.TileRelatedClasses.Trap;

import java.util.HashMap;

public class TrapAction extends Action{
    private int maxRange;
    private ActionType actionType;
    private int accuracy;
    TrapEffect trapEffect;

    public TrapAction(int maxRange, int accuracy, TrapEffect trapEffect) {
        this.maxRange = maxRange;
        this.accuracy = accuracy;
        this.trapEffect = trapEffect;
    }

    @Override
    public Action clone(int modifier) {
        Action action = new TrapAction(this.maxRange,this.accuracy, this.trapEffect);
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

    public void apply(Trap trap, int distance){
        if(distance * accuracy > 1){
            trapEffect.apply(trap);
        }
        else {
            //miss
        }
    }


}
