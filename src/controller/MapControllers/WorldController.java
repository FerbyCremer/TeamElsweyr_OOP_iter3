package controller.MapControllers;

import controller.EntityControllers.AIController;
import controller.Handlers.ActionHandler;
import controller.Handlers.BringOutYourDeadHandler;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSet;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSetContainer;
import controller.MapControllers.FogOfWarRelatedClasses.FogOfWarController;
import controller.MapControllers.MovementRelatedControllers.EntityToAreaEffect;
import controller.MapControllers.MovementRelatedControllers.EntityToItem;
import controller.MapControllers.MovementRelatedControllers.EntityToTrap;
import controller.MapControllers.MovementRelatedControllers.MovementController;
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
    private BringOutYourDeadHandler deadHandler;
    private AIController aiController;

    public WorldController(World world, Player player, DecalSetContainer decalSetContainer, ZoneView zoneView, ZoneController zoneController, ActionHandler actionHandler, BringOutYourDeadHandler deadHandler, AIController aiController) {
        this.world = world;
        this.player = player;
        this.decalSetContainer = decalSetContainer;
        this.zoneView = zoneView;
        this.zoneController = zoneController;
        this.actionHandler = actionHandler;
        this.deadHandler = deadHandler;
        this.aiController = aiController;
    }

    public WorldController(){}

	public void changeZoneTo(String zoneID){
        updatePlayerPos(zoneID);
        updateWorldController(zoneID);
    }

    public void updateWorldController(String zoneID){
        Zone newZone = world.changeZone(zoneID);
        updateZoneController(newZone);
        updateActionHandler(newZone);
        updateDeadHandler(newZone);
        updateAIController(newZone);
        //updateZoneView(decalSetContainer.getDecalSet(zoneID));
    }

    public void runGame(){
        zoneController.startGameLoop();
    }

    private void updateActionHandler(Zone zone){
        actionHandler.setActionPerformer(zone);
    }

    private void updateDeadHandler(Zone zone){
        deadHandler.setEntityRemover(zone);
    }

    private void updatePlayerPos(String zoneID){
        world.removeEntityFromZone(player);
        world.addEntityToZone(player, zoneID);
    }
    private void updateAIController(Zone zone){
        aiController.updateMaps(zone);
    }

    private void updateZoneController(Zone zone){
        zoneController.setEntityToAreaEffect(new EntityToAreaEffect(zone));
        zoneController.setEntityToItem(new EntityToItem(zone));
        zoneController.setEntityToTrap(new EntityToTrap(zone));
        zoneController.setMovementController(new MovementController(zone));
        zoneController.setFogOfWarController(new FogOfWarController(player, zone, decalSetContainer.getDecalSet(zone.getID())));
    }

    public void setWorld(World world) {
        this.world = world;
    }

    /*private void updateZoneView(DecalSet decalSet){
        zoneView.updateZoneView(decalSet);
    }*/
}
