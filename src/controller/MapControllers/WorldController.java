package controller.MapControllers;

import controller.EntityControllers.AIController;
import controller.Handlers.ActionHandler;
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
    private AIController aiController;

    public WorldController(World world, Player player, DecalSetContainer decalSetContainer, ZoneView zoneView, ZoneController zoneController, ActionHandler actionHandler, AIController aiController) {
        this.world = world;
        this.player = player;
        this.decalSetContainer = decalSetContainer;
        this.zoneView = zoneView;
        this.zoneController = zoneController;
        this.actionHandler = actionHandler;
        this.aiController = aiController;
    }

    public void changeZoneTo(String zoneID){
        updatePlayerPos(zoneID);
        updateZoneController(world.changeZone(zoneID));
        updateZoneView(decalSetContainer.getDecalSet(zoneID));
    }
    public void runGame(){}

    private void updateActionHandler(Zone zone){
    }
    private void updateAIController(Zone zone){}

    private void updatePlayerPos(String zoneID){
        world.removeEntityFromZone(player);
        world.addEntityToZone(player, zoneID);
    }
    private void updateZoneController(Zone zone){
        zoneController.setEntityToAreaEffect(new EntityToAreaEffect(zone));
        zoneController.setEntityToItem(new EntityToItem(zone));
        zoneController.setEntityToTrap(new EntityToTrap(zone));
        zoneController.setMovementController(new MovementController(zone));
        zoneController.setFogOfWarController(new FogOfWarController(player, zone, decalSetContainer.getDecalSet(zone.getID())));
    }
    private void updateZoneView(DecalSet decalSet){
        zoneView.updateZoneView(decalSet);
    }

}
