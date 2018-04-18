package controller.MapControllers.MovementRelatedControllers;

import model.Entities.Entity;
import model.Map.Zone.ContentMap;

public class EntityMover {
    Entity entity;
    private int cooldown;

    public EntityMover(Entity entity) {
        this.entity = entity;
    }

    public void changeLocation(ContentMap<Entity> entityContentMap){}
}
