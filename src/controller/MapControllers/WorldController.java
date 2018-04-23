package controller.MapControllers;

import controller.EntityControllers.AIController;
import controller.Handlers.ActionHandler;
import controller.Handlers.BringOutYourDeadHandler;
import controller.Handlers.MountHandler;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSet;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSetContainer;
import controller.MapControllers.FogOfWarRelatedClasses.FogOfWarController;
import controller.MapControllers.MovementRelatedControllers.EntityToAreaEffect;
import controller.MapControllers.MovementRelatedControllers.EntityToItem;
import controller.MapControllers.MovementRelatedControllers.EntityToTrap;
import controller.MapControllers.MovementRelatedControllers.MovementController;
import javafx.stage.Stage;
import model.Entities.Player;
import model.Map.World;
import model.Map.Zone.Zone;
import view.ZoneView;

import java.awt.*;

//TODO change player's MountHandler when map changes
public class WorldController {
    private World world;
    private Player player;
    private DecalSetContainer decalSetContainer;
    private ZoneView zoneView;
    private ZoneController zoneController;
    private ActionHandler actionHandler;
    private MountHandler mountHandler;
    private BringOutYourDeadHandler deadHandler;

    public WorldController(ZoneController zoneController, ActionHandler actionHandler, MountHandler mountHandler, BringOutYourDeadHandler deadHandler) {
        this.zoneController = zoneController;
        this.actionHandler = actionHandler;
        this.mountHandler = mountHandler;
        this.deadHandler = deadHandler;

       // this.zoneView = new ZoneView();
    }

//    public WorldController(){}

	public void changeZoneTo(String zoneID){
        updatePlayerPos(zoneID);
        updateWorldController(zoneID);
    }

    public void updateWorldController(String zoneID){

        Zone newZone = world.changeZone(zoneID);
        updateZoneController(newZone);
        updateActionHandler(newZone);
        updateMountHandler(newZone);
        updateDeadHandler(newZone);
        //updateZoneView(decalSetContainer.getDecalSet(zoneID));
    }

    public void runGame(){
        zoneController.startGameLoop();
    }

    private void updateActionHandler(Zone zone){
        actionHandler.setActionPerformer(zone);
    }

    private void updateMountHandler(Zone zone ) { mountHandler.setMountPerformer(zone); }

    private void updateDeadHandler(Zone zone){
        deadHandler.setEntityRemover(zone);
    }

    private void updatePlayerPos(String zoneID){
        world.removeEntityFromZone(player);
        world.addEntityToZone(player, zoneID);
    }

    public World getWorld() {
        return world;
    }

    private void updateZoneController(Zone zone){
        zoneController.setEntityToAreaEffect(new EntityToAreaEffect(zone));
        zoneController.setEntityToItem(new EntityToItem(zone));
        zoneController.setEntityToTrap(new EntityToTrap(zone));
        zoneController.setMovementController(new MovementController(zone));
        zoneController.setFogOfWarController(new FogOfWarController(player, zone, decalSetContainer.getDecalSet(zone.getID())));
        zoneController.updateAIController(zone);
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void setPlayer(Player player) { this.player = player; }

    public void setDecalSetContainer(){
        decalSetContainer = new DecalSetContainer(world);
    }

    /*private void updateZoneView(DecalSet decalSet){
        zoneView.updateZoneView(decalSet);
    }*/
}
