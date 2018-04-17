package controller.MapControllers;

import controller.EntityControllers.AIController;
import controller.Handlers.ActionHandler;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSet;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSetContainer;
import model.Entities.Player;
import model.Map.World;
import model.Map.Zone.Zone;
import view.ZoneView;

import java.awt.*;

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

    public void changeZoneTo(String zoneID){}
    public void runGame(){}

    private void updateActionHandler(Zone zone){}
    private void updateAIController(Zone zone){}
    private void updateZoneController(Zone zone){}
    private void updateZoneView(DecalSet decalSet, Point playerPos){}

}
