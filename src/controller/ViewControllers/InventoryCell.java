package controller.ViewControllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import model.Inventory.Inventory;
import model.Items.Takeable.Takeable;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class InventoryCell extends ListCell<Takeable> {
    private final RadioButton radioButton = new RadioButton();
    private Takeable selectedItem = this.getItem();

    protected Inventory bag;

    public ToggleGroup group = new ToggleGroup();

    public InventoryCell(Inventory bag) {
        this.bag = bag;
        radioButton.setToggleGroup(group);

        radioButton.setText(selectedItem.getName());

        radioButton.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                //selectedItem = getItem();
                updateItem(selectedItem, true);
            }
            if (wasSelected) {
                updateItem(selectedItem, false);
            }
        });

    }

    public void update(Takeable obj, boolean empty) {
        super.updateItem(obj, empty);
        if (empty == false) {
            radioButton.setSelected(false);
            //obj.setEquip(false);
        } else {
            radioButton.setSelected(true);
            bag.equipItem(this.getIndex());
        }
    }

    @Override
    protected void updateItem(Takeable model, boolean bln) {
        super.updateItem(model, bln);
//TODO: Equipment logic somehow here
        if (model != null) {
//            radioButton.setText(model.getName());

            URL location = InventoryCell.class.getResource("InventoryView.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            try {
                Node root = (Node) fxmlLoader.load(location.openStream());
                InventoryController controller = (InventoryController) fxmlLoader.getController();
                controller.setModel(this);
                setGraphic(root);
            } catch (IOException ioe) {
                throw new IllegalStateException(ioe);
            }
        }
    }
}
