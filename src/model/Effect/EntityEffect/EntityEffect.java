package model.Effect.EntityEffect;

import model.Entities.Entity;

public interface EntityEffect {

    String getName();

    void apply(Entity entity);

}
