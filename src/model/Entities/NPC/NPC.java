package model.Entities.NPC;

import controller.EntityControllers.AIController;
import controller.Handlers.BringOutYourDeadHandler;
import model.Entities.AI;
import model.Entities.EntityStats;
import model.Entities.Player;
import model.Inventory.Inventory;
import model.Map.Terrain;

import java.util.List;

public class NPC extends AI {
    private NPCState npcState;
    public NPC(EntityStats stats, BringOutYourDeadHandler deadHandler, AIController aiController, Inventory inventory, List<Terrain> terrains, String name, NPCState npcState){
    	super(stats, deadHandler, aiController, inventory, terrains, name);
        this.npcState = npcState;
        this.aiController = aiController;
    }
    @Override
    public void move() {
        npcState.move(aiController, this);
    }

    public void setState(NPCState npcState){
        this.npcState = npcState;
    }

    public void doInteraction(Player player){
        npcState.performInteraction(this, player);

    }

    public void visit(Player player){
        npcState.performInteraction(this, player);
    }
}
