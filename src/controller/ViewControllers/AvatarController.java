package controller.ViewControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AvatarController implements Initializable {

    @FXML ImageView avatar;
    @FXML RadioButton scout;
    @FXML RadioButton warrior;
    @FXML RadioButton healer;

    protected Image[] avatars = {new Image("assets/avatars/lgAvatar/1.png"), new Image("assets/avatars/lgAvatar/2.png"), new Image("assets/avatars/lgAvatar/3.png"),
            new Image("assets/avatars/lgAvatar/4.png"), new Image("assets/avatars/lgAvatar/5.png"), new Image("assets/avatars/lgAvatar/6.png"),new Image("assets/avatars/lgAvatar/7.png"),
            new Image("assets/avatars/lgAvatar/8.png"), new Image("assets/avatars/lgAvatar/9.png"), new Image("assets/avatars/lgAvatar/10.png"), new Image("assets/avatars/lgAvatar/11.png"),
            new Image("assets/avatars/lgAvatar/12.png"), new Image("assets/avatars/lgAvatar/13.png"), new Image("assets/avatars/lgAvatar/14.png"), new Image("assets/avatars/lgAvatar/15.png")};

    private final Node sneak = new ImageView("assets/avatars/skillCards/scout.png");
    private final Node smasher = new ImageView("assets/avatars/skillCards/warrior.png");
    private final Node summoner = new ImageView("assets/avatars/skillCards/healer.png");

    private int i = 0;
    ToggleGroup skills = new ToggleGroup();

    public void initialize(URL url, ResourceBundle bundle){
        avatar.setImage(avatars[i]);

        Tooltip a = new Tooltip();
        a.setGraphic(sneak);
        scout.setTooltip(a);
        scout.setOnAction( event -> {
            //ToDo: playerMakeSneak()
        });

        Tooltip b = new Tooltip();
        b.setGraphic(smasher);
        warrior.setTooltip(b);
        warrior.setOnAction( event -> {
            //ToDo: playerMakeSmasher()
        });

        Tooltip c = new Tooltip();
        c.setGraphic(summoner);
        healer.setTooltip(c);
        healer.setOnAction( event -> {
            //ToDo: playerMakeSummoner()
        });

        skills.getToggles().addAll(scout, warrior, healer);
    }

    @FXML private void leftCycle(){
        if(i != 0)
            i--;
        else
            i = avatars.length - 1;
    }

    @FXML private void rightCycle(){
        if(i != avatars.length - 1)
            i++;
        else
            i = 0;
    }

    @FXML private void startGame(){
        //TODO: initialize new game
    }

    @FXML protected void setAvatar(){
        //TODO: parse in avatar object into game loader
    }
}
