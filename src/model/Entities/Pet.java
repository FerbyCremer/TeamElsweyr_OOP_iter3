package model.Entities;

import controller.EntityControllers.AIController;
import controller.Handlers.BringOutYourDeadHandler;
import model.Entities.NPC.NPCState;
import model.Inventory.Inventory;
import model.Map.Terrain;

import java.util.List;

public class Pet extends AI {

    public Pet(EntityStats stats, BringOutYourDeadHandler deadHandler, AIController aiController, Inventory inventory, List<Terrain> terrains, String name){
    	super(stats, deadHandler, aiController, inventory, terrains, name);
    }

	@Override
	public void move() {
    	aiController.movePet(this);
	}
}
