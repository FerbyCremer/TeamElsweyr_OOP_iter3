package model.Entities;

import controller.EntityControllers.AIController;
import controller.Handlers.BringOutYourDeadHandler;
import model.Inventory.Inventory;
import model.Map.Terrain;

import java.util.List;

public abstract class AI extends Entity {
	protected AIController aiController;
    public abstract void move();
    
	public AI(EntityStats entityStats, BringOutYourDeadHandler deadHandler, AIController aiController, Inventory inventory, List<Terrain> terrains, String name) {
		super(entityStats, inventory, terrains, name, deadHandler);
		this.aiController = aiController;
	}
}
