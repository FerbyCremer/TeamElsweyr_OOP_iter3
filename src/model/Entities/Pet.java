package model.Entities;

import controller.EntityControllers.AIController;
import controller.Handlers.BringOutYourDeadHandler;
import controller.LoadGame.SaveVisitor;
import model.Entities.NPC.NPCState;
import model.Inventory.Inventory;
import model.Map.Terrain;

import java.util.List;

public class Pet extends AI {

    public Pet(EntityStats stats, BringOutYourDeadHandler deadHandler, AIController aiController, Inventory inventory, List<Terrain> terrains, String name){
    	super(stats, deadHandler, aiController, inventory, terrains, name);
    }

    @Override
    public String accept(SaveVisitor saveVisitor){
        return saveVisitor.savePet(this);
    }

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}
}
