package view.viewReferenceCode;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import controller.ViewControllers.test.ChoiceCell;
import controller.ViewControllers.test.ChoiceModel;

public class MainController implements Initializable
{
    @FXML
    private ListView<ChoiceModel> choicesView;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        choicesView.setCellFactory(new Callback<ListView<ChoiceModel>, ListCell<ChoiceModel>>()
        {
            public ListCell<ChoiceModel> call(ListView<ChoiceModel> p)
            {
                return new ChoiceCell();
            }
        });
        choicesView.setItems(FXCollections.observableArrayList
                (
                        new ChoiceModel("Tiger", true),
                        new ChoiceModel("Shark", false),
                        new ChoiceModel("Bear", false),
                        new ChoiceModel("Wolf", true)
                ));
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
}