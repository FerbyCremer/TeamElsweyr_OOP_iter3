package model.Items.OneShot;

import controller.LoadGame.SaveVisitor;
import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Entity;
import model.Items.Item;

public class OneShot extends Item {
    private EntityEffect effect;

    public OneShot(EntityEffect effect) {
        this.effect = effect;
    }

    @Override
    public void touchedBy(Entity entity) {
        effect.apply(entity);
        delete();
    }

    public EntityEffect getEffect() {
        return effect;
    }

    private void delete() {
        delete();

    }


    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveOneShot(this);
    }
}
