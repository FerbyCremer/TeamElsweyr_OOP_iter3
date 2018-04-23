package controller.ViewControllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import model.Entities.Skill;
import model.Items.Takeable.Takeable;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class LevelUpCell extends ListCell<Skill> {


    private final Button levelUp = new Button();

    private Skill skill;
    public ButtonGroup group = new ButtonGroup();

    public LevelUpCell(Skill skill) {
        this.skill = skill;
        levelUp.setDefaultButton(true);

        levelUp.setOnAction((obs) -> skill.increaseLevel());
    }


    @Override
    protected void updateItem(Skill skill, boolean bln)
    {
        super.updateItem(skill, bln);
//TODO: Equipment logic somehow here
        if(skill != null)
        {
            levelUp.setText(skill.getName());

            URL location = InventoryCell.class.getResource("LevelUpView.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            try
            {
                Node root = (Node)fxmlLoader.load(location.openStream());
                //do I need this:
//                InventoryController controller = (InventoryController) fxmlLoader.getController();
////                controller.equip(model);
                setGraphic(root);
            }
            catch(IOException ioe)
            {
                throw new IllegalStateException(ioe);
            }
        }
    }


}
