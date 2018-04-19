package controller.MapControllers.MovementRelatedControllers;

import model.Entities.Entity;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.AreaEffect;
import model.Map.Zone.Zone;

public class EntityToAreaEffect implements CollisionChecker {
    private ContentMap<Entity> entityMap;
    private ContentMap<AreaEffect> areaEffectMap;

    public EntityToAreaEffect(Zone zone){
        entityMap = zone.getEntityMap();
        areaEffectMap = zone.getAreaEffectMap();
    }


    @Override
    public void checkCollision() {

    }
}
