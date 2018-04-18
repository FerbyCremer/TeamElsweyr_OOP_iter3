package controller.MapControllers;

import controller.MapControllers.FogOfWarRelatedClasses.FogOfWarController;
import controller.MapControllers.MovementRelatedControllers.EntityToAreaEffect;
import controller.MapControllers.MovementRelatedControllers.EntityToItem;
import controller.MapControllers.MovementRelatedControllers.EntityToTrap;
import controller.MapControllers.MovementRelatedControllers.MovementController;

public class ZoneController {
    private MovementController movementController;
    private EntityToItem itemCollison;
    private EntityToAreaEffect areaEffectCollision;
    private EntityToTrap trapCollision;
    private FogOfWarController fogOfWarController;

    public ZoneController(MovementController movementController, EntityToItem itemCollison, EntityToAreaEffect areaEffectCollision, EntityToTrap trapCollision, FogOfWarController fogOfWarController) {
        this.movementController = movementController;
        this.itemCollison = itemCollison;
        this.areaEffectCollision = areaEffectCollision;
        this.trapCollision = trapCollision;
        this.fogOfWarController = fogOfWarController;
    }

    public void startTimer(){}

    public void setMovementController(MovementController movementController){
        this.movementController = movementController;
    }

    public void setEntityToItem(EntityToItem entityToItem){
        itemCollison = entityToItem;
    }

    public void setEntityToAreaEffect(EntityToAreaEffect entityToAreaEffect){
        areaEffectCollision = entityToAreaEffect;
    }

    public void setEntityToTrap(EntityToTrap entityToTrap){
        trapCollision = entityToTrap;
    }

    public void setFogOfWarController(FogOfWarController fogOfWarController){
        this.fogOfWarController = fogOfWarController;
    }
}
