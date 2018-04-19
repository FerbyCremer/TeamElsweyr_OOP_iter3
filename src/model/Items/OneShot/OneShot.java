package model.Items.OneShot;

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

    private void delete() {
    }


}
