package controller.MapControllers;

import controller.MapControllers.FogOfWarRelatedClasses.FogOfWarController;
import controller.MapControllers.MovementRelatedControllers.*;

import java.util.Timer;
import java.util.TimerTask;

public class ZoneController {
    private MovementController movementController;
    private EntityToItem itemCollison;
    private EntityToAreaEffect areaEffectCollision;
    private EntityToTrap trapCollision;
    private FogOfWarController fogOfWarController;

    public ZoneController(MovementController movementController, EntityToItem itemCollison, EntityToAreaEffect areaEffectCollision, EntityToTrap trapCollision, FogOfWarController fogOfWarController) {
//        this.movementController = movementController;
//        this.itemCollison = itemCollison;
//        this.areaEffectCollision = areaEffectCollision;
//        this.trapCollision = trapCollision;
//        this.fogOfWarController = fogOfWarController;
    }

    public ZoneController(){

    }

    private class GameLoop extends TimerTask {

        @Override
        public void run() {
            movementController.updateEntitys();
            itemCollison.checkCollision();
            areaEffectCollision.checkCollision();
            trapCollision.checkCollision();
            fogOfWarController.update();
        }
    }

    public void startGameLoop(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new GameLoop(), 1000, 10);
    }

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
