package model.Entities;

import controller.EntityControllers.AIController;

public abstract class AI extends Entity {
    protected AIController aiController;
    public abstract void move();
}
