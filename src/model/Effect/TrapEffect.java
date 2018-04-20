package model.Effect;

import model.Entities.Entity;

public abstract class TrapEffect {

    public TrapEffect() {
    }

    public abstract void apply(Entity entity);
}
