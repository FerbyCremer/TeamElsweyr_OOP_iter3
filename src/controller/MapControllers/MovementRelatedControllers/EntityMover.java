package controller.MapControllers.MovementRelatedControllers;

import model.Entities.Entity;
import model.Map.Direction;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.Tile;

public class EntityMover {
    private ContentMap<Entity> entityMap;
    private Entity entity;
    private int cooldown;

    public EntityMover(Entity entity, ContentMap<Entity> entityMap) {
        this.entity = entity;
        this.entityMap = entityMap;
        this.cooldown = 0;
    }

    public void changeLocation(Tile tileToMoveTo){

        int currentSpeed = entity.getCurrentSpeed();
        if (cooldown <= 0 && currentSpeed > 0){
            //Check if entity is there
            if (entityMap.hasTile(tileToMoveTo)){
                entityMap.getContentAtTile(tileToMoveTo).accept(entity);
            }

            else if (tileToMoveTo.canMove(entity)){
                entityMap.setNewLocation(tileToMoveTo, entity);
            }

            resetCooldown(currentSpeed);
        }
        cooldown--;
    }

    private void resetCooldown(double speed){
        cooldown = (int) (1/speed * 10);
        //System.out.print(cooldown);
        //cooldown = 5;
    }
}
