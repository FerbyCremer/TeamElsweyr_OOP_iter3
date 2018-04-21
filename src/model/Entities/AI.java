package model.Entities;

import controller.EntityControllers.AIController;
import controller.Handlers.BringOutYourDeadHandler;

public abstract class AI extends Entity {
	protected AIController aiController;
    public abstract void move();
}
