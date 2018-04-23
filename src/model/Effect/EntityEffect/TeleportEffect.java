package model.Effect.EntityEffect;

import controller.LoadGame.SaveVisitor;
import controller.MapControllers.WorldController;
import model.Entities.Entity;

import java.time.ZoneId;

public class TeleportEffect implements EntityEffect {
    private WorldController worldController;
    private String zoneId;
    private String name;

    public TeleportEffect(WorldController worldController, String zoneId) {
        this.worldController = worldController;
        this.zoneId = zoneId;
    }

    @Override
    public void apply(Entity entity) {
        worldController.changeZoneTo(zoneId);
    }

    @Override
    public String getName() {
        return "teleportEffect";
    }

    @Override
    public String getAmount() {
        return ""+zoneId;
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return getName()+"\n"+getAmount()+"\n";
    }
}
