package model.Entities.NPC;

import controller.EntityControllers.AIController;
import controller.Handlers.BringOutYourDeadHandler;
import model.Entities.AI;
import model.Entities.EntityStats;
import model.Entities.Player;

public class NPC extends AI {
    private NPCState npcState;

    public NPC(EntityStats stats, BringOutYourDeadHandler deadHandler, AIController aiController, NPCState npcState){
    	super(stats, deadHandler, aiController);
        this.npcState = npcState;
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
