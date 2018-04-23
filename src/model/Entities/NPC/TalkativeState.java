package model.Entities.NPC;

import controller.EntityControllers.AIController;
import controller.LoadGame.SaveVisitor;
import model.Entities.Player;
import view.UpdateEntityRelatedView;

import java.util.ArrayList;

public class TalkativeState implements NPCState {
    //Dialogue
    private ArrayList<UpdateEntityRelatedView> observers;

    public TalkativeState(){}


    @Override
    public void move(AIController aiController, NPC npc) {

    }

    //Might want to have dialogue observer
    @Override
    public void performInteraction(NPC npc, Player player) {
        for(UpdateEntityRelatedView v: observers)
            v.update(npc);
    }


    @Override
    public String accept(SaveVisitor saveVisitor) {
        return "talkativeState\n";
    }
}
