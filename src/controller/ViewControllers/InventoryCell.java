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

public class InventoryCell extends ListCell<Takeable>
{
    private final RadioButton radioButton = new RadioButton();
    private Takeable selectedItem;

    public ToggleGroup group = new ToggleGroup();
    InventoryCell() {
        radioButton.setToggleGroup(group);
        radioButton.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                //selectedItem = getItem();
                selectedItem.setEquip(true);
            }
            if(wasSelected) {
                selectedItem.setEquip(false);
            }
        });
    }

    @Override
    public void updateItem(Takeable obj, boolean empty) {
        super.updateItem(obj, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            radioButton.setText(obj.getName());//TODO: TDA?

            radioButton.setSelected(Objects.equals(obj, selectedItem.getName()));

            setGraphic(radioButton);
        }
    }
}

    /*@Override
    protected void updateItem(Takeable model, boolean bln)
    {
        super.updateItem(model, bln);

        if(model != null)
        {
            radioButton.setText(model.getName());
            URL location = InventoryCell.class.getResource("InventoryView.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            try
            {
                Node root = (Node)fxmlLoader.load(location.openStream());
                InventoryController controller = (InventoryController) fxmlLoader.getController();
                //controller.equip(model);
                setGraphic(root);
            }
            catch(IOException ioe)
            {
                throw new IllegalStateException(ioe);
            }
        }
    }
}*/
