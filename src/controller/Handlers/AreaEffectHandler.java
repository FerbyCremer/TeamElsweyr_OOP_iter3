package controller.Handlers;

import model.Entities.Entity;
import model.Map.Zone.TileRelatedClasses.AreaEffect;

public class AreaEffectHandler {


    public AreaEffectHandler() { }

    public void handleCollision(Entity entity, AreaEffect areaEffect){
        areaEffect.apply(entity);
    }
}
