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
import model.Items.Takeable.Takeable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameObserver implements Initializable {

    @FXML BorderPane base;
    @FXML ListView<Takeable> inventoryList;
    //TODO: find way to get player and/or other entities
    private Entity player;
    private Inventory bag = player.getInventory();
    private Scene scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inventoryList.setCellFactory(new Callback<ListView<Takeable>, ListCell<Takeable>>()
        {
            public ListCell<Takeable> call(ListView<Takeable> p)
            {
                return new InventoryCell(bag);
            }
        });
        inventoryList.setItems(FXCollections.observableArrayList(bag.getItems()));
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
