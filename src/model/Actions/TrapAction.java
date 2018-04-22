package model.Actions;


import controller.Handlers.ActionHandler;
import controller.LoadGame.SaveVisitor;
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
    TrapEffect trapEffect;

    public TrapAction(int maxRange, int accuracy, ActionType type, TrapEffect trapEffect) {
        this.maxRange = maxRange;
        this.accuracy = accuracy;
        this.trapEffect = trapEffect;
        this.actionType = type;
    }

    @Override
    public Action clone(double modifier) {
        int modifiedAccuracy =  (int) (this.accuracy * modifier);
        Action action = new TrapAction(this.maxRange, modifiedAccuracy, this.actionType, this.trapEffect);
        return action;
    }

    @Override
    public HashMap<Tile, Integer> getAffectedTiles(Tile tile, Direction direction) {
        return actionType.generateAffectedTiles(tile, direction, this);
    }

    @Override
    public String saveEffect(SaveVisitor saveVisitor) {
        return "";
    }

    @Override
    public void createInstanceFor(ActionHandler actionHandler, Player player) {
        actionHandler.createAction(player, this);
    }


    @Override
    public String getEffectName() {
        return "trapEffect\n" + trapEffect.getName();
    }

    public void apply(Trap trap, int distance){
        if(distance * accuracy > 1){
            trapEffect.apply(trap);
        }
        else {
            //miss
        }
    }


    @Override
    public String accept(SaveVisitor saveVisitor) {
        return "trapAction";
    }
}
