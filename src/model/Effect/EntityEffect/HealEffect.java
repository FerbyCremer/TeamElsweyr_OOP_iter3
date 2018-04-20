package model.Effect.EntityEffect;

import model.Entities.Entity;

public class HealEffect implements EntityEffect {
    private int amount;

    public HealEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(Entity entity) {
        entity.updateHealth(amount);
    }
}
