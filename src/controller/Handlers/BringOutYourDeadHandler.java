package controller.Handlers;

import model.Entities.Entity;
import model.Map.Zone.ContentMap;
import model.Map.Zone.Zone;

public class BringOutYourDeadHandler {

    private EntityRemover entityRemover;

    public BringOutYourDeadHandler(Zone zone) {
        entityRemover = new EntityRemover(zone);
    }

    public void notifyEntityDead(Entity entity){
        entityRemover.removeEntity(entity);
    }

    public void setEntityRemover(Zone zone) {
        this.entityRemover = new EntityRemover(zone);
    }
}
