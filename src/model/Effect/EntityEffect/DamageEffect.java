package model.Effect.EntityEffect;

import model.Entities.Entity;

public class DamageEffect implements EntityEffect{
    private int amount;

    public DamageEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(Entity entity) {
        entity.updateHeath(amount);
    }
}
