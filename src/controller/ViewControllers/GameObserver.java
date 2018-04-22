package controller.ViewControllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import model.Entities.Entity;
import model.Inventory.Inventory;

import javafx.scene.control.ListView;

import controller.ViewControllers.test.ChoiceCell;
import controller.ViewControllers.test.ChoiceModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameObserver implements Initializable {

    @FXML BorderPane base;
    //@FXML ListView<Takeable> inventoryList;
    @FXML ListView<ChoiceModel> inventoryList;
    private Entity player;
//    private Inventory bag = player.getInventory();
    private Scene scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*inventoryList.setCellFactory(new Callback<ListView<Takeable>, ListCell<Takeable>>()
        {
            public ListCell<Takeable> call(ListView<Takeable> p)
            {
                return new InventoryCell();
            }
        });
        inventoryList.setItems(FXCollections.observableArrayList(bag.getItems()));
        */
        inventoryList.setCellFactory(new Callback<ListView<ChoiceModel>, ListCell<ChoiceModel>>()
        {
            public ListCell<ChoiceModel> call(ListView<ChoiceModel> p)
            {
                return new ChoiceCell();
            }
        });
        inventoryList.setItems(FXCollections.observableArrayList
                (
                        new ChoiceModel("Tiger", true),
                        new ChoiceModel("Shark", false),
                        new ChoiceModel("Bear", false),
                        new ChoiceModel("Wolf", true)
                ));

    }

    @FXML
    protected void equip(int item) {
       // bag.equipItem(item);
    }

    @FXML
    protected void sell(int item, Inventory shop) {
       // bag.removeItem(item);
      ///  bag.modifyWealth(5);
    }

    @FXML
    protected void buy(int item, Inventory shop) {
        //this.inventory.addItem(item);
       // bag.modifyWealth(-5);
    }

    private void showScene() throws IOException {
        Platform.runLater(() -> {

            Stage stage = (Stage) base.getScene().getWindow();
            stage.setResizable(true);
            stage.setWidth(1080);
            stage.setHeight(720);

            stage.setOnCloseRequest((WindowEvent e) -> {
                Platform.exit();
                System.exit(0);
            });
            stage.setScene(this.scene);
            //stage.setScene(new Scene(root));

            stage.setMinWidth(800);
            stage.setMinHeight(300);
            //ResizeHelper.addResizeListener(stage);
            stage.centerOnScreen();
        });
    }
}
