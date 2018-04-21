package model.Map.Zone.TileRelatedClasses;

import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Entity;

public class Trap {
    private boolean visible;
    private boolean active;
    private EntityEffect effect;
    private String name;

    public Trap(boolean visible, boolean active, EntityEffect effect) {
        this.visible = visible;
        this.active = active;
        this.effect = effect;
        this.name = "Trap";
    }

    public void apply(Entity entity){
        effect.apply(entity);
        visible = true;
        active = false;
    }

    public void setVisiblity(boolean b){
        visible = b;
    }

    public void setActive(){
        active = true;
    }

    public String getName() {
        if(visible)
            return name;
        return null;
    }

}
