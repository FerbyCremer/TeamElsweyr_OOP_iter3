package controller.MapControllers.MovementRelatedControllers;

import model.Entities.Entity;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.Trap;
import model.Map.Zone.Zone;

public class EntityToTrap implements CollisionChecker {
    private ContentMap<Entity> entityMap;
    private ContentMap<Trap> trapMap;

    public EntityToTrap(Zone zone){
        entityMap = zone.getEntityMap();
        trapMap = zone.getTrapMap();
    }


    @Override
    public void checkCollision() {

    }
}
