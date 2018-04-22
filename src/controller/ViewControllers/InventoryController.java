package controller.ViewControllers;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import model.Entities.Entity;
import model.Entities.Player;
import model.Inventory.Inventory;
import model.Items.Takeable.Takeable;
import model.Updateable;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Objects;

public class InventoryController {


   /* private Node view;
    private testController controller;


    public InventoryController() {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/InventoryView.fxml"));
            fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
                @Override
                public Object call(Class<?> param) {
                    return controller = new testController();
                }
            });
            try {
                view = (Node) fxmlLoader.load();


            } catch (IOException ex) {
            }
            getChildren().add(view);
        }
*/

    private final ChangeListener<Boolean> IS_SELECTED_CHANGE_LISTENER = new ChangeListener<Boolean>()
    {
        public void changed(ObservableValue<? extends Boolean> property, Boolean oldValue, Boolean newValue)
        {
            updateIsSelectedView(newValue);
        }
    };

    @FXML
    private Label labelView;

    @FXML
    private RadioButton isSelectedView;

    private Takeable model;

    public Takeable getModel()
    {
        return model;
    }

    public void setModel(Takeable model)
    {
        if(this.model != null)
            removeModelListeners();
        this.model = model;
        setupModelListeners();
        updateView();
    }

    private void removeModelListeners()
    {
        labelView.setText(model.getName());
        model.isEquippedProperty().removeListener(IS_SELECTED_CHANGE_LISTENER);
        isSelectedView.selectedProperty().unbindBidirectional(model.isEquippedProperty());
    }

    private void setupModelListeners()
    {
        labelView.setText( model.getName());
        model.isEquippedProperty().addListener(IS_SELECTED_CHANGE_LISTENER);
        isSelectedView.selectedProperty().bindBidirectional(model.isEquippedProperty());
    }

    private void updateView()
    {
        updateIsSelectedView();
    }

    private void updateIsSelectedView(){ updateIsSelectedView(model.isEquipped()); }
    private void updateIsSelectedView(boolean newValue)
    {
        isSelectedView.setSelected(newValue);
    }

    private class onClickItem implements EventHandler<ActionEvent> {
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
    }

    /*public String getText() {
        return textProperty().get();
    }

    public void setText(String value) {
        textProperty().set(value);
    }

    public StringProperty textProperty() {
        return textField.textProperty();
    }*/



}
