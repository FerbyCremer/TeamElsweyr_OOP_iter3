package model.Effect.EntityEffect;

import controller.LoadGame.SaveVisitor;
import model.Entities.Entity;

public class ExpEffect implements EntityEffect {
    private int amount;
    private String name;

    public ExpEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(Entity entity) {

    }

    @Override
    public String getName() {
        return "expEffect";
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
