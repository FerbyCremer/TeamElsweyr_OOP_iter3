package model.Entities.NPC;

import controller.EntityControllers.AIController;
import model.Entities.AI;
import model.Entities.Player;

public class NPC extends AI {
    private NPCState npcState;

    public NPC(NPCState npcState, AIController aiController){
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
