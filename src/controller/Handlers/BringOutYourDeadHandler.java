package controller.Handlers;

import controller.EntityControllers.AIController;
import model.Entities.Entity;
import model.Map.Zone.ContentMap;
import model.Map.Zone.Zone;

public class BringOutYourDeadHandler {

    private EntityRemover entityRemover;
    private AIController aiController;

    public BringOutYourDeadHandler(AIController aiController) {
        this.aiController = aiController;
    }

    public void notifyEntityDead(Entity entity){
        entityRemover.removeEntity(entity);
        notifyAIController(entity);
    }

    private void notifyAIController(Entity entity){
        aiController.removeEntity(entity);
    }

    public void setEntityRemover(Zone zone) {
        this.entityRemover = new EntityRemover(zone);
    }
}
