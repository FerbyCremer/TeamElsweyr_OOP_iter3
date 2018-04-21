package controller.ViewControllers;

import controller.KeyControllers.KeyCommands.KeyCommand;
import controller.KeyControllers.KeyControlState;
import controller.KeyControllers.KeyController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.util.Callback;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class KeyBindingController implements Initializable {

    @FXML TableView player;
    @FXML TableView inventory;
    @FXML TableView camera;

    @FXML private TableColumn playerCommand;
    @FXML private TableColumn playerKey;

    @FXML private TableColumn inventoryCommand;
    @FXML private TableColumn inventoryKey;

    @FXML private TableColumn cameraCommand;
    @FXML private TableColumn cameraKey;

   // private KeyController player = new KeyController("player", )

   // private ObservableList<KeyCommand> playerCommandList = FXCollections.observableArrayList(loadKeyCodes())

    public void initialize(URL url, ResourceBundle resourceBundle) {

                playerCommand.setCellValueFactory(
                new PropertyValueFactory<KeyCommand, String>("name"));

                playerKey.setCellValueFactory( new PropertyValueFactory<KeyCommand, KeyCode>("keyCode"));

                playerKey.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent event) {
                        KeyCommand command = (KeyCommand) event.getRowValue();
                        command.setKeyCode((KeyCode) event.getNewValue());
                    }
                });

        inventoryCommand.setCellValueFactory(
                new PropertyValueFactory<KeyCommand, String>("name"));

        inventoryKey.setCellValueFactory( new PropertyValueFactory<KeyCommand, KeyCode>("keyCode"));

        inventoryKey.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
                KeyCommand command = (KeyCommand) event.getRowValue();
                command.setKeyCode((KeyCode) event.getNewValue());
            }
        });

        cameraCommand.setCellValueFactory(
                new PropertyValueFactory<KeyCommand, String>("name"));

        cameraKey.setCellValueFactory( new PropertyValueFactory<KeyCommand, KeyCode>("keyCode"));

        cameraKey.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
            @Override
            public void handle(TableColumn.CellEditEvent event) {
                KeyCommand command = (KeyCommand) event.getRowValue();
                command.setKeyCode((KeyCode) event.getNewValue());
            }
        });
    }

    public KeyCode getKeyCodeFor(String name){
        //TODO get keycode from name from file
        return KeyCode.K;
    }

    public void loadKeyCodes(List<KeyCommand> commands){
        for(KeyCommand key : commands){
            KeyCode keyCode = getKeyCodeFor(key.getName());
            key.setKeyCode(keyCode);
        }
    }
}
