package model.Actions;

import controller.Handlers.ActionHandler;
import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;
import model.Actions.ActionType.ActionType;
import model.Entities.Player;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;

import java.util.HashMap;

public abstract class Action implements Saveable{

    protected int maxRange;
    protected int distanceTraveled;
    protected ActionType actionType;
    protected int accuracy;


    public abstract Action clone(double modifier);
    public abstract HashMap<Tile, Integer> getAffectedTiles(Tile tile, Direction direction);

    public boolean targetHit(int distance){
        double distanceModifier = 1;
        if (distance != 1){
            distanceModifier = 1/Math.log(distance);
        }

        double random = Math.random()*100;

        if(accuracy*distanceModifier > random) {
            return true;
        }
        return false;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public abstract String saveEffect(SaveVisitor saveVisitor);

    public abstract void createInstanceFor(ActionHandler actionHandler, Player player);

    public abstract String getEffectName();

    public int getAccuracy() {
        return accuracy;
    }
}
