package view;

import controller.ViewControllers.InventoryCell;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.Entities.Entity;
import model.Inventory.Inventory;
import model.Items.Item;
import model.Items.Takeable.Takeable;

import java.util.List;

public class TradeView implements UpdateEntityRelatedView {


    protected Entity shop;

    protected Inventory playerInventory;
    protected Inventory npcInventory;

    @FXML protected ListView<Takeable> playerInventoryList;
    @FXML protected ListView<Takeable> npcInventoryList;


    public TradeView(){ }


    @Override
    public void update(Entity... entities) {
        playerInventory = entities[0].getInventory();
        npcInventory = entities[1].getInventory();
        constructButtons();
    }


    private void constructButtons(){

        playerInventoryList.setCellFactory(new Callback<ListView<Takeable>, ListCell<Takeable>>()
        {
            public ListCell<Takeable> call(ListView<Takeable> p)
            {
                return new InventoryCell(playerInventory);
            }
        });
        playerInventoryList.setItems(FXCollections.observableArrayList(playerInventory.getItems()));

        npcInventoryList.setCellFactory(new Callback<ListView<Takeable>, ListCell<Takeable>>()
        {
            public ListCell<Takeable> call(ListView<Takeable> p)
            {
                return new InventoryCell(npcInventory);
            }
        });
        npcInventoryList.setItems(FXCollections.observableArrayList(npcInventory.getItems()));
    }
    @FXML
    protected void sell(int item, Inventory shop, Inventory actor) {
        actor.removeItem(item);
        actor.modifyWealth(5);
        this.buy(actor.getItems().get(item), actor, shop);
    }

    @FXML
    protected void buy(Takeable item, Inventory shop, Inventory actor) {
        actor.addItem(item);
        actor.modifyWealth(item.getPrice() * -1);
        this.sell(actor.getItems().indexOf(item), actor, shop);
    }
}
