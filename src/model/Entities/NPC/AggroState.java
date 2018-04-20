package model.Entities.NPC;

import controller.EntityControllers.AIController;
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
        findPlayer(aiController, npc);
    }

    @Override
    public void performInteraction(NPC npc, Player player) {
        player.updateHealth(attackDamage);
    }

    private void findPlayer(AIController aiController, NPC npc){
        //TODO: Change find PathToPlayer take in an entity and find the distance direction between the player and npc
        ArrayList<Direction> directions = aiController.findPathToEntity(npc);
        npc.move(directions.get(0));
    }

    private void attackPlayer(){

    }

}
