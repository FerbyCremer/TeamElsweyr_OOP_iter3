package model.Entities.NPC;

import controller.EntityControllers.AIController;
import model.Entities.Player;
import model.Updateable;

import java.util.ArrayList;

public class TalkativeState implements NPCState {
    //Dialogue
    private ArrayList<Updateable> observers;

    public TalkativeState(){}


    @Override
    public void move(AIController aiController, NPC npc) {

    }

    //Might want to have dialogue observer
    @Override
    public void performInteraction(NPC npc, Player player) {

    }
}
