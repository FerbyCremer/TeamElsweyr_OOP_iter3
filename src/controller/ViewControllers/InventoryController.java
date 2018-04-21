package controller.ViewControllers;

import javafx.fxml.FXML;
import model.Inventory.Inventory;
import model.Updateable;

public class InventoryController implements Updateable{
    @FXML public int money = 0;
    private Inventory inventory;

    public InventoryController(){}

    public InventoryController(Inventory inventory){
        this.inventory = inventory;
    }

    @Override
    public void update() {
        money = inventory.getWealth();
    }
}
