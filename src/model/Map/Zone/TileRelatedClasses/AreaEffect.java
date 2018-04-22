package model.Map.Zone.TileRelatedClasses;

import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;
import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Entity;

public class AreaEffect implements Saveable{
    private EntityEffect effect;

    public EntityEffect getEffect() {
        return effect;
    }

    public AreaEffect(EntityEffect effect) {
        this.effect = effect;
    }

    public void apply(Entity entity){
        effect.apply(entity);
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveAreaEffect(this);
    }
}
