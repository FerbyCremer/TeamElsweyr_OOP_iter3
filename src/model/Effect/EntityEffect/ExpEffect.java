package model.Effect.EntityEffect;

import model.Entities.Entity;

public class ExpEffect implements EntityEffect {
    private int amount;

    public ExpEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(Entity entity) {

    }
}
