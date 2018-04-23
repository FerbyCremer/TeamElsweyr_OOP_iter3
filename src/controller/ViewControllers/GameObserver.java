package controller.ViewControllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
    @FXML ListView<Takeable> inventoryList;
    @FXML Group canvas = new Group();
    @FXML VBox stats;
    //TODO: find way to get player and/or other entities
    private Player player;
    private Inventory bag;
    @FXML
    private ListView<ChoiceModel> choicesView;
    private Scene scene;

    public void setPlayer(Player player){
        this.player = player;
        bag = this.player.getInventory();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*this.inventoryList = new ListView<>();
        this.inventoryList.setCellFactory(new Callback<ListView<Takeable>, ListCell<Takeable>>()
        {
            public ListCell<Takeable> call(ListView<Takeable> p)
            {
                return new InventoryCell(bag);
            }
        });
        if (bag != null){
            this.inventoryList.setItems(FXCollections.observableArrayList(bag.getItems()));
        }*/
        choicesView.setCellFactory(new Callback<ListView<ChoiceModel>, ListCell<ChoiceModel>>()
        {
            public ListCell<ChoiceModel> call(ListView<ChoiceModel> p)
            {
                return new ChoiceCell();
            }
        });
        System.out.println("akdjfl;asdjfl;asjdfl;jasdl;fjasd");
        choicesView.setItems(FXCollections.observableArrayList
                (
                        new ChoiceModel("Tiger", true),
                        new ChoiceModel("Shark", false),
                        new ChoiceModel("Bear", false),
                        new ChoiceModel("Wolf", true)
                ));
    }

    public void setCanvas(Group canvas) {
        this.canvas = canvas;
    }

    @FXML
    private void handleForceChange(ActionEvent event)
    {
        if(choicesView != null && choicesView.getItems().size() > 0)
        {
            boolean isSelected = choicesView.getItems().get(0).isSelected();
            choicesView.getItems().get(0).setSelected(!isSelected);
        }
    }

    //TODO needed for pulling up ingame menu, also change stage size
    public void showScene() throws IOException {
        Platform.runLater(() -> {

            Stage stage = (Stage) inventoryList.getScene().getWindow();
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

    public void setScene(Scene mainScene) {
        scene = mainScene;
    }
}
