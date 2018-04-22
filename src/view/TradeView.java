package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.Entities.Entity;
import model.Inventory.Inventory;
import model.Items.Item;
import model.Items.Takeable.Takeable;

import java.util.List;

public class TradeView implements UpdateEntityRelatedView {

    private Inventory playerInventory;
    private Inventory npcInventory;
    private List<Button> playerButtons;
    private List<Button> npcButtons;
    public TradeView(){}

    @Override
    public void update(Entity... entities) {
        playerInventory = entities[0].getInventory();
        npcInventory = entities[1].getInventory();
        constructButtons();
    }


    private void constructButtons(){
        playerButtons.clear();
        npcButtons.clear();

        List<Takeable> playerItems = playerInventory.getItems();
        for(Takeable item : playerItems){
            Button button = new Button(item.getName());
            button.setOnAction(new onClickSell(playerInventory, npcInventory, item));
            playerButtons.add(button);
        }

        List<Takeable> npcItems = npcInventory.getItems();
        for(Takeable item : npcItems){
            Button button = new Button(item.getName());
            button.setOnAction(new onClickSell(npcInventory, playerInventory, item));
            npcButtons.add(button);
        }
    }

    private class onClickSell implements EventHandler<ActionEvent>
    {
        private Inventory prevOwner;
        private Inventory newOwner;
        private Takeable item;
        public onClickSell(Inventory prevOwner, Inventory newOwner, Takeable item){
            this.prevOwner = prevOwner;
            this.newOwner = newOwner;
            this.item = item;
        }
        @Override
        public void handle(ActionEvent event) {
            prevOwner.removeItem(item);
            //prevOwner.updateWealth(item.getWealth())
            newOwner.addItem(item);
        }
    }
}
