package model.Effect.EntityEffect;

import model.Entities.Entity;

public class BargainEffect implements EntityEffect {
    private int amount;
    private String name;

    public BargainEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(Entity entity) {

    }

    @Override
    public String getName() {
        return name;
    }
}
