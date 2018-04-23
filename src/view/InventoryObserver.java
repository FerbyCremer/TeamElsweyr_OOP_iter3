package view;

import controller.ViewControllers.InventoryCell;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.Entities.Entity;
import model.Inventory.Inventory;
import model.Items.Takeable.Takeable;

public class InventoryObserver implements UpdateEntityRelatedView {

        protected Entity player;

        protected Inventory playerInventory = player.getInventory();
        @FXML protected ListView<Takeable> playerInventoryList;

        public InventoryObserver(Entity player){
            this.player = player;
            constructButtons();
        }

        @Override
        public void update(Entity... entities) {
            playerInventory = player.getInventory();
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

        }
    @FXML protected void equip(Takeable item) {
        int itemIndex = playerInventory.getItems().indexOf(item);
        playerInventory.equipItem(itemIndex);
    }

}
