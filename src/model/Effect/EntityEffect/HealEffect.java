package model.Effect.EntityEffect;

import model.Entities.Entity;

public class HealEffect implements EntityEffect {
    private String name;
    private int amount;

    public HealEffect(int amount) {
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
