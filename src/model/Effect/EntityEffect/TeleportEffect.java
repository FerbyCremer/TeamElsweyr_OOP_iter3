package model.Effect.EntityEffect;

import controller.MapControllers.WorldController;
import model.Entities.Entity;

import java.time.ZoneId;

public class TeleportEffect implements EntityEffect {
    private WorldController worldController;
    private String zoneId;

    public TeleportEffect(WorldController worldController, String zoneId) {
        this.worldController = worldController;
        this.zoneId = zoneId;
    }

    @Override
    public void apply(Entity entity) {
        worldController.changeZoneTo(zoneId);
    }
}
