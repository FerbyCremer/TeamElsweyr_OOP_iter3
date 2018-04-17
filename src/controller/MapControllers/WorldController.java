package controller.MapControllers;

import controller.EntityControllers.AIController;
import controller.Handlers.ActionHandler;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSetContainer;
import model.Entities.Player;
import model.Map.World;
import view.ZoneView;

public class WorldController {
    private World world;
    private Player player;
    private DecalSetContainer decalSetContainer;
    private ZoneView zoneView;
    private ZoneController zoneController;
    private ActionHandler actionHandler;
    private AIController aiController;
}
