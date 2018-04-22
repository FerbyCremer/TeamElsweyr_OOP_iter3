package controller.ViewControllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Entities.Player;
import model.Entities.Skill;
import model.Inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

//Corresponds to the save game menu or something beats me
public class SkillPointAssignment {
    private Player player;
    private List<String> skillNames;
    private List<Integer> skillLevels;
    private List<Skill> skills;
    private int skillPointsRemaining;
    private List<Button> skillButtons;
    private List<Button> levelButtons;
    private List<TextField> skillLevelIncreaseAmount;

    private GridPane gridPane;
    public SkillPointAssignment(Player player){
        gridPane = new GridPane();
    }

    public SkillPointAssignment(){
        gridPane = new GridPane();
    }

    public void doSkillPointAssignment(){
        setPlayerSkillRelatedInfo();
        createSkillPointAssignmentViewElements();

    }

    private void createSkillPointAssignmentViewElements() {
        skillButtons = new ArrayList<Button>();
        levelButtons = new ArrayList<Button>();
        for(int i = 0; i < skillNames.size(); i++){
            Button button = new Button(skillNames.get(i));
            Button button2 = new Button(levelButtons.get(i).toString());
            TextField text= new TextField();

            gridPane.setConstraints(button, 0, i);
            gridPane.getChildren().add(button);
            gridPane.setConstraints(button2,1,i);
            gridPane.getChildren().add(button2);
            gridPane.setConstraints(text,2,i);
            gridPane.getChildren().add(text);
            skillLevelIncreaseAmount.add(text);
        }

        Button submit = new Button("Submit");
    }

    private void setPlayerSkillRelatedInfo(){
        setSkillNamesAndLevels();
        setSkillPoints();
    }

    private void setSkillNamesAndLevels(){
        skills = player.getSkills();
        skillNames = new ArrayList<String>();
        skillLevels = new ArrayList<Integer>();
        for(Skill skill : skills){
            skillNames.add(skill.getName());
            skillLevels.add(skill.getLevel());
        }
    }

    private void setSkillPoints() {
        //skillPointsRemaining = player.getSkillPoints();
    }

    private class onSumbit implements EventHandler<ActionEvent>{


        @Override
        public void handle(ActionEvent event) {
            int sum = 0;
            List<Integer> integers = new ArrayList<Integer>();
            for(TextField textField : skillLevelIncreaseAmount){
                String temp = textField.getText();
                Integer integer = new Integer(temp);
                sum += integer;
                integers.add(integer);
            }
            if(sum > skillPointsRemaining){

            }
            else {
                //player.setSkillPoints(skillPointsRemaining - sum);
//                for(int i = 0; i < skills.size(); i++){
//                    skills.get(i).updateLevel(skillLevelIncreaseAmount.get(i));
//                }
            }
        }
    }

}
