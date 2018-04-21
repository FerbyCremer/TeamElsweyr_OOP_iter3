package model.Effect.EntityEffect;

import model.Entities.Entity;

public class ObserveEffect implements EntityEffect {
    private String name;
    private int amount;

    public ObserveEffect(int amount) {
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
