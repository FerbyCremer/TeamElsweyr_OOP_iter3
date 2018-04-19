package model.Map.Zone.TileRelatedClasses;

import model.Effect.EntityEffect;
import model.Entities.Entity;

public class Trap {
    private boolean visible;
    private boolean active;
    private EntityEffect effect;
    private String name;

    public Trap(boolean visible, boolean active, EntityEffect effect, String name) {
        this.visible = visible;
        this.active = active;
        this.effect = effect;
        this.name = name;
    }

    public void apply(Entity entity){
        effect.apply(entity);
    }

    public void setVisiblity(boolean b){
        visible = b;
    }

    public String getName() {
        if(visible)
            return name;
        return null;
    }
}
