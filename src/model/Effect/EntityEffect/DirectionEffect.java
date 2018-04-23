package model.Effect.EntityEffect;

import controller.LoadGame.SaveVisitor;
import model.Entities.Entity;
import model.Map.Direction;

public class DirectionEffect implements EntityEffect{
    private int amount;

    public DirectionEffect(int amount){
        this.amount = amount;
    }

    @Override
    public String getName() {
        return "directionEffect";
    }

    @Override
    public String getAmount() {
        return Integer.toString(amount);
    }

    @Override
    public void apply(Entity entity) {
        amount %= 3;

        entity.setFacingDirection(Direction.getDirectionClosest(90* amount));
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return (getName() + "\n" + getAmount() + "\n");
    }
}
