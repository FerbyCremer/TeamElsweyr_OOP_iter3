package model.Effect.EntityEffect;

import model.Entities.Entity;

public class BargainEffect implements EntityEffect {
    private int amount;

    public BargainEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(Entity entity) {

    }
}
