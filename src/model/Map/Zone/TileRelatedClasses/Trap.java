package model.Map.Zone.TileRelatedClasses;

import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Entity;

public class Trap {
    private boolean visible;
    private boolean active;
    private EntityEffect effect;

    public Trap(boolean visible, boolean active, EntityEffect effect) {
        this.visible = visible;
        this.active = active;
        this.effect = effect;
    }

    public void apply(Entity entity){
        effect.apply(entity);
    }

    public void setVisiblity(boolean b){
        visible = b;
    }
}
