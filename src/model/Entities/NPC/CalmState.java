package model.Entities.NPC;

import controller.EntityControllers.AIController;
import controller.LoadGame.SaveVisitor;
import model.Entities.Player;

public class CalmState implements NPCState {

    public CalmState(){}


    @Override
    public void move(AIController aiController, NPC npc) {

    }

    @Override
    public void performInteraction(NPC npc, Player player) {

    }

    private void waitToBeAttacked(){}

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return "calmState\n";
    }
}
