package model.Map.Zone.TileRelatedClasses;

import model.Effect.EntityEffect;
import model.Entities.Entity;

public class AreaEffect {
    private EntityEffect effect;

    public AreaEffect(EntityEffect effect) {
        this.effect = effect;
    }

    public void apply(Entity entity){
        effect.apply(entity);
    }
}
