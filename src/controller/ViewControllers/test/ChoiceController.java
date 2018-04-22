package controller.ViewControllers.test;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class ChoiceController
{
    private final ChangeListener<String> LABEL_CHANGE_LISTENER = new ChangeListener<String>()
    {
        public void changed(ObservableValue<? extends String> property, String oldValue, String newValue)
        {
            updateLabelView(newValue);
        }
    };

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
    private CheckBox isSelectedView;

    private ChoiceModel model;

    public ChoiceModel getModel()
    {
        return model;
    }

    public void setModel(ChoiceModel model)
    {
        if(this.model != null)
            removeModelListeners();
        this.model = model;
        setupModelListeners();
        updateView();
    }

    private void removeModelListeners()
    {
        model.labelProperty().removeListener(LABEL_CHANGE_LISTENER);
        model.isSelectedProperty().removeListener(IS_SELECTED_CHANGE_LISTENER);
        isSelectedView.selectedProperty().unbindBidirectional(model.isSelectedProperty());
    }

    private void setupModelListeners()
    {
        model.labelProperty().addListener(LABEL_CHANGE_LISTENER);
        model.isSelectedProperty().addListener(IS_SELECTED_CHANGE_LISTENER);
        isSelectedView.selectedProperty().bindBidirectional(model.isSelectedProperty());
    }

    private void updateView()
    {
        updateLabelView();
        updateIsSelectedView();
    }

    private void updateLabelView(){ updateLabelView(model.getLabel()); }
    private void updateLabelView(String newValue)
    {
        labelView.setText(newValue);
    }

    private void updateIsSelectedView(){ updateIsSelectedView(model.isSelected()); }
    private void updateIsSelectedView(boolean newValue)
    {
        isSelectedView.setSelected(newValue);
    }
}