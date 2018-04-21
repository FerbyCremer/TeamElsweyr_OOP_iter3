package model.Effect;

import model.Entities.Entity;

public abstract class TrapEffect {
    protected String name;
    public TrapEffect() {
    }

    public abstract void apply(Entity entity);

    public String getName() {
        return name;
    }
}
