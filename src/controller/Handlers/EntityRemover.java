package controller.Handlers;

import model.Entities.Entity;
import model.Map.Zone.ContentMap;
import model.Map.Zone.Zone;

public class EntityRemover {
    private ContentMap<Entity> entityContentMap;

    public EntityRemover(Zone zone){
        this.entityContentMap = zone.getEntityMap();
    }

    public void removeEntity(Entity entity){
        entityContentMap.removeContent(entity);
    }

}
