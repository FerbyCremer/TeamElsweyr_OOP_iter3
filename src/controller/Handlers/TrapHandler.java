package controller.Handlers;

import model.Entities.Entity;
import model.Map.Zone.TileRelatedClasses.Trap;

public class TrapHandler {
    public TrapHandler(){ }

    public void handleCollision(Entity entity, Trap trap){
        trap.apply(entity);
    }
}
