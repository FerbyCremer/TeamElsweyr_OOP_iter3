package model.Entities.NPC;

import controller.EntityControllers.AIController;
import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;
import model.Entities.AI;
import model.Entities.Player;

public class NPC extends AI implements Saveable{
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

    public NPCState getNpcState() {
        return npcState;
    }

    public void visit(Player player){
        npcState.performInteraction(this, player);
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveNPC(this);
    }
}
