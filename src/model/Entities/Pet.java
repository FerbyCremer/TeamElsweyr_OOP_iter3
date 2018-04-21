package model.Entities;

import controller.EntityControllers.AIController;
import controller.Handlers.BringOutYourDeadHandler;

public class Pet extends AI {

    public Pet(EntityStats stats, BringOutYourDeadHandler deadHandler, AIController aiController){
    	super(stats, deadHandler, aiController);
    }

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
