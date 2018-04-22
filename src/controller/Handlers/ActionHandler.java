package controller.Handlers;

import model.Actions.Action;
import model.Actions.EntityAction;
import model.Actions.TrapAction;
import model.Entities.Entity;
import model.Entities.Player;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.HashMap;

public class ActionHandler {
    private ActionPerformer actionPerformer;

/*    public ActionHandler(Zone zone) {
        actionPerformer = new ActionPerformer(zone);
    }*/

    public void createAction(Player player, Action action){
        action.createInstanceFor(this, player);
    }

    public void createAction(Player player, EntityAction entityAction){
        actionPerformer.performAction(player, entityAction);
    }

    public void createAction(Player player, TrapAction trapAction){
        actionPerformer.performAction(player, trapAction);
    }


    public void setActionPerformer(Zone zone) {
        this.actionPerformer = new ActionPerformer(zone);
    }
}
