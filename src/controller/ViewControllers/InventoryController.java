package controller.ViewControllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Inventory.Inventory;
import model.Updateable;

import java.util.ArrayList;
import java.util.List;

public class InventoryController implements Updateable{
    @FXML public int money = 0;
    private Inventory inventory;
    private List<Button> buttons;

    public InventoryController(){
        buttons = new ArrayList<Button>();
    }

    public InventoryController(Inventory inventory){
        this.inventory = inventory;
        buttons = new ArrayList<Button>();

    }

    @Override
    public void update() {
        money = inventory.getWealth();
        List<String> itemNames = getInventoryItems();
        makeButtons(itemNames);

    }

    private List<String> getInventoryItems(){
        return inventory.getItemNames();
    }

    private void makeButtons(List<String> items){
        buttons.clear();
        //TODO: cleanup as this is relying on the implementation of the inventory classes equip
        int index = 0;
        for(String item : items){
            Button button = new Button(item);
            button.setOnAction(new onClickItem(index, inventory));
            buttons.add(button);
            index++;
        }
    }

    private class onClickItem implements EventHandler<ActionEvent> {
        private int index;
        private Inventory inventory;

        public onClickItem(int index, Inventory inventory){
            this.index = index;
            this.inventory = inventory;
        }
        @Override
        public void handle(ActionEvent event) {
            inventory.equipItem(index);
        }
    }

}
