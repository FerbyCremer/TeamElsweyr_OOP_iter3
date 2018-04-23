package model.Entities.NPC;

import controller.EntityControllers.AIController;
import controller.LoadGame.SaveVisitor;
import model.Entities.Player;
import model.Map.Direction;
import java.util.ArrayList;

public class AggroState implements NPCState {
    private int attackDamage;


    public AggroState(){
        attackDamage = -2;
    }
    @Override
    public void move(AIController aiController, NPC npc) {
        aiController.moveToPlayer(npc);
    }

    @Override
    public void performInteraction(NPC npc, Player player) {
        player.updateHealth(attackDamage);
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return "aggroState\n";
    }

    public int getAttackDamage(){
        return attackDamage;
    }
}
