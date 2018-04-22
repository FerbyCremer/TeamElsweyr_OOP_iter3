package model.Effect.EntityEffect;

import controller.LoadGame.SaveVisitor;
import model.Entities.Entity;

public class DamageEffect implements EntityEffect{
    private int amount;
    private String name;

    public DamageEffect(int amount) {
        this.amount = amount;
        this.name = "damage";
    }

    @Override
    public void apply(Entity entity) {
        entity.updateHealth(amount);
    }

    @Override
    public String getName() {
        return "damageEffect";
    }

    @Override
    public String getAmount() {
        return ""+amount;
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        System.out.println("get amount - " + getAmount());
        String saver = getName()+"\n" + getAmount()+"\n";
        System.out.println("GET AMOUNT AND NAME = " + saver);
        return (getName()+"\n" + getAmount()+"\n");
    }
}
