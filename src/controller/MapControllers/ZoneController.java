package controller.MapControllers;

import controller.EntityControllers.AIController;
import controller.EntityControllers.AIController;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSet;
import controller.MapControllers.FogOfWarRelatedClasses.FogOfWarController;
import controller.MapControllers.MovementRelatedControllers.*;
import javafx.animation.AnimationTimer;
import model.Map.Zone.TileRelatedClasses.Decal;
import view.ZoneView;
import model.Map.Zone.Zone;

import java.util.Timer;
import java.util.TimerTask;

public class ZoneController {
    private MovementController movementController;
    private EntityToItem itemCollison;
    private EntityToAreaEffect areaEffectCollision;
    private EntityToTrap trapCollision;
    private FogOfWarController fogOfWarController;
    private ZoneView zoneView;
    private AIController aiController;

    public ZoneController(MovementController movementController, ZoneView zoneView, EntityToItem itemCollison, EntityToAreaEffect areaEffectCollision, EntityToTrap trapCollision, FogOfWarController fogOfWarController) {
//        this.movementController = movementController;
//        this.itemCollison = itemCollison;
//        this.areaEffectCollision = areaEffectCollision;
//        this.trapCollision = trapCollision;
//        this.fogOfWarController = fogOfWarController;
          this.zoneView = zoneView;
    }

    public ZoneController(ZoneView zoneview, AIController aiController) {
        this.zoneView = zoneview;
        this.aiController = aiController;
    }


    private class GameLoop extends AnimationTimer {

/*        @Override
        public void run() {
        }*/
        private long lastUpdate = 0;

        @Override
        public void handle(long now) {
            if ((now - lastUpdate) >= (long) 100000){
                aiController.makeAIDecision();
                movementController.updateEntitys();
                itemCollison.checkCollision();
                areaEffectCollision.checkCollision();
                trapCollision.checkCollision();
                fogOfWarController.update();
                zoneView.renderGrid();
                lastUpdate = now;
            }
        }
    }

    public void startGameLoop(){
        new GameLoop().start();
        //Timer timer = new Timer();
        //timer.scheduleAtFixedRate(new GameLoop(), 2000, 500);
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

    public void updateAIController(Zone zone){ aiController.updateMaps(zone); }

    public void updateZoneView(DecalSet decalSet){ zoneView.updateZoneView(decalSet); }
}
