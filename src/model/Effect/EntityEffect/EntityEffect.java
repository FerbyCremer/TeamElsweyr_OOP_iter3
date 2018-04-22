package model.Effect.EntityEffect;

import controller.LoadGame.Saveable;
import model.Entities.Entity;

public interface EntityEffect extends Saveable{

    String getName();

    String getAmount();

    void apply(Entity entity);

}
