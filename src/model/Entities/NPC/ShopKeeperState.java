package model.Entities.NPC;

import controller.EntityControllers.AIController;
import model.Entities.Player;
import view.UpdateEntityRelatedView;

import java.util.ArrayList;

public class ShopKeeperState implements NPCState {
    private ArrayList<UpdateEntityRelatedView> observers;

    public ShopKeeperState(){}


    @Override
    public void move(AIController aiController, NPC npc) {

    }

    //Open buySell interaction might want to have buy/sell observer
    @Override
    public void performInteraction(NPC npc, Player player) {
        for(UpdateEntityRelatedView v: observers)
            v.update(player, npc);
    }


}
