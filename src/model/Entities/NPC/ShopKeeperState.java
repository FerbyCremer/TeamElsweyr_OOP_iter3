package model.Entities.NPC;

import controller.EntityControllers.AIController;
import model.Entities.Player;

public class ShopKeeperState implements NPCState {

    public ShopKeeperState(){}


    @Override
    public void move(AIController aiController, NPC npc) {

    }

    //Open buySell interaction might want to have buy/sell observer
    @Override
    public void performInteraction(NPC npc, Player player) {

    }


}
