package model.Effect.EntityEffect;

import model.Entities.Entity;

public class DamageEffect implements EntityEffect{
    private int amount;
    private String name;

    public DamageEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(Entity entity) {
        entity.updateHealth(amount);
    }

    @Override
    public String getName() {
        return name;
    }
}
