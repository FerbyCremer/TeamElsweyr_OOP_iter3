package model.Effect.EntityEffect;

import controller.LoadGame.SaveVisitor;
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
        return "healEffect";
    }

    @Override
    public String getAmount() {
        return ""+amount;
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return getName()+"\n"+getAmount()+"\n";
    }
}
