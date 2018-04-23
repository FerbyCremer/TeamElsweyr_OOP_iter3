package model.Entities.NPC;

import controller.EntityControllers.AIController;
import controller.LoadGame.SaveVisitor;
import model.Entities.Player;
import view.TradeView;
import view.UpdateEntityRelatedView;

import java.util.ArrayList;
import java.util.List;

public class ShopKeeperState implements NPCState {
    private List<UpdateEntityRelatedView> observers;

    public ShopKeeperState(TradeView tradeView){
        observers = new ArrayList<>();
        observers.add(tradeView);
    }


    @Override
    public void move(AIController aiController, NPC npc) {

    }

    //Open buySell interaction might want to have buy/sell observer
    @Override
    public void performInteraction(NPC npc, Player player) {
        for(UpdateEntityRelatedView v: observers)
            v.update(player, npc);
    }


    @Override
    public String accept(SaveVisitor saveVisitor) {
        return "shopKeeperState\n";
    }
}
