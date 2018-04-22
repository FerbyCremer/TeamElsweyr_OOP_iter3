package controller.ViewControllers.test;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class ChoiceCell extends ListCell<ChoiceModel>
{
    @Override
    protected void updateItem(ChoiceModel model, boolean bln)
    {
        super.updateItem(model, bln);

        if(model != null)
        {
            URL location = ChoiceController.class.getResource("ChoiceView.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            try
            {
                Node root = (Node)fxmlLoader.load(location.openStream());
                ChoiceController controller = (ChoiceController)fxmlLoader.getController();
                controller.setModel(model);
                setGraphic(root);
            }
            catch(IOException ioe)
            {
                throw new IllegalStateException(ioe);
            }
        }
    }
}