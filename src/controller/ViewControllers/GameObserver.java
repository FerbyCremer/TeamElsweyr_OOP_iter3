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
import model.Entities.Player;
import model.Inventory.Inventory;

import javafx.scene.control.ListView;

import controller.ViewControllers.test.ChoiceCell;
import controller.ViewControllers.test.ChoiceModel;
import model.Items.Takeable.Takeable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameObserver implements Initializable {

    @FXML BorderPane base;
    @FXML ListView<Takeable> inventoryList;
    //TODO: find way to get player and/or other entities
    private Player player;
    private Inventory bag;

    private Scene scene;

    public void setPlayer(Player player){
        this.player = player;
        bag = this.player.getInventory();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inventoryList = new ListView<>();
        inventoryList.setCellFactory(new Callback<ListView<Takeable>, ListCell<Takeable>>()
        {
            public ListCell<Takeable> call(ListView<Takeable> p)
            {
                return new InventoryCell(bag);
            }
        });
        if (bag != null){
            inventoryList.setItems(FXCollections.observableArrayList(bag.getItems()));
        }
    }


//TODO needed for pulling up ingame menu, also change stage size
    private void showScene() throws IOException {
        Platform.runLater(() -> {

            Stage stage = (Stage) base.getScene().getWindow();
            stage.setResizable(true);
            stage.setMaximized(true);

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