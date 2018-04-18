package controller.Handlers;

import model.Entities.Entity;
import model.Map.Zone.TileRelatedClasses.Trap;

public class TrapHandler {
    Entity entity;

    public TrapHandler(Entity entity, Trap trap){
        this.entity = entity;
    }

    private void handleCollision(Trap trap){}
}
