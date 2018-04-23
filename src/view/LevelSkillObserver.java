package view;

import controller.ViewControllers.LevelUpCell;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.Entities.Player;
import model.Entities.Skill;
import model.Items.Takeable.Takeable;

import java.util.List;

public class LevelSkillObserver extends ListCell<Skill>{

    protected Player player;

    protected List<Skill> skilllist = player.getSkills();


    @FXML
    protected ListView<Skill> playerSkillList;

    public LevelSkillObserver(Player player){
        this.player = player;
        constructButtons();
    }

    public void update(Player player) {
        skilllist = player.getSkills();
        constructButtons();
    }


    private void constructButtons(){
        playerSkillList.setCellFactory(p -> new LevelUpCell(skilllist.get(0)));
        playerSkillList.setItems(FXCollections.observableArrayList(skilllist));
    }

    @FXML protected void levelUp(Skill skill) {
        int indexToLevelUp = skilllist.indexOf(skill);
        skilllist.get(indexToLevelUp).increaseLevel();
    }

}