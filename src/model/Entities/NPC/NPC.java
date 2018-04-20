package model.Entities.NPC;

import model.Entities.AI;
import model.Entities.Player;

public class NPC extends AI {
    private NPCState npcState;

    public NPC(NPCState npcState){
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
