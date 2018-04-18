package model.Effect;

import model.Entities.Entity;

public abstract class EntityEffect {

    public EntityEffect() {
    }

    public abstract void apply(Entity entity);
}
