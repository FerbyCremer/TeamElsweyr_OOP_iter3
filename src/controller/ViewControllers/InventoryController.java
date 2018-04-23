package controller.ViewControllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Inventory.Inventory;
import model.Items.Takeable.Takeable;

public class InventoryController {

    private final ChangeListener<Boolean> IS_SELECTED_CHANGE_LISTENER = new ChangeListener<Boolean>()
    {
        public void changed(ObservableValue<? extends Boolean> property, Boolean oldValue, Boolean newValue)
        {
            updateIsSelectedView(newValue);
        }
    };

    @FXML private Label labelView;
    @FXML private RadioButton isSelectedView;

    private InventoryCell model;

    public InventoryCell getModel()
    {
        return model;
    }
    private Inventory bag = model.bag;

    private Takeable item = model.getItem();



    public void setModel(InventoryCell model)
    {
        if(this.model != null)
            removeModelListeners();
        this.model = model;
        setupModelListeners();
        updateView();
    }

    private void removeModelListeners()
    {
        labelView.setText(null);
        item.isEquippedProperty().removeListener(IS_SELECTED_CHANGE_LISTENER);
        isSelectedView.selectedProperty().unbindBidirectional(item.isEquippedProperty());
    }

    private void setupModelListeners()
    {
        labelView.setText( item.getName());
        item.isEquippedProperty().addListener(IS_SELECTED_CHANGE_LISTENER);
        isSelectedView.selectedProperty().bindBidirectional(item.isEquippedProperty());
    }

    private void updateView()
    {
        updateIsSelectedView();
    }

    private void updateIsSelectedView(){ updateIsSelectedView(item.isEquipped()); }
    private void updateIsSelectedView(boolean newValue)
    {
        isSelectedView.setSelected(newValue);
    }

/*    private class onClickItem implements EventHandler<ActionEvent> {
        private int index;
        private Inventory inventory;

        public onClickItem(int index, Inventory inventory) {
            this.index = index;
            this.inventory = inventory;
        }

        @Override
        public void handle(ActionEvent event) {
            inventory.equipItem(index);
        }
    }*/
}
