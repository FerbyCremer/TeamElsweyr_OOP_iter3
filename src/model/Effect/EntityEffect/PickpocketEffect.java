package model.Effect.EntityEffect;

import controller.LoadGame.SaveVisitor;
import model.Entities.Entity;

public class PickpocketEffect implements EntityEffect{
    private int amount;

    public PickpocketEffect(){
        amount = 0;
    }

    @Override
    public String getName() {
        return "pickpocket";
    }

    @Override
    public String getAmount() {
        return Integer.toString(amount);
    }

    @Override
    public void apply(Entity entity) {
        entity.setStolen();
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return (getName() + "\n" + getAmount() + "\n");
    }
}
