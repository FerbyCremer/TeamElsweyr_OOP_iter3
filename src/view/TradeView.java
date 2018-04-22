package view;

import model.Entities.Entity;
import model.Inventory.Inventory;

public class TradeView implements UpdateEntityRelatedView {

    private Inventory playerInventory;
    private Inventory npcInventory;
    public TradeView(){}
    @Override
    public void update(Entity... entities) {
        playerInventory = entities[0].getInventory();
        npcInventory = entities[1].getInventory();
    }
}
