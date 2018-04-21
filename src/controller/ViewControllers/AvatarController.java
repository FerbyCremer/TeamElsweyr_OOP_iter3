package controller.ViewControllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AvatarController implements Initializable {

    @FXML ImageView avatar;
    @FXML ToggleButton scout;
    @FXML ToggleButton warrior;
    @FXML ToggleButton healer;
    @FXML ImageView skillsCard;
    @FXML private BorderPane base;

    protected Image[] avatars = {new Image("assets/avatars/lgAvatar/1.png"), new Image("assets/avatars/lgAvatar/2.png"), new Image("assets/avatars/lgAvatar/3.png"),
            new Image("assets/avatars/lgAvatar/4.png"), new Image("assets/avatars/lgAvatar/5.png"), new Image("assets/avatars/lgAvatar/6.png"),new Image("assets/avatars/lgAvatar/7.png"),
            new Image("assets/avatars/lgAvatar/8.png"), new Image("assets/avatars/lgAvatar/9.png"), new Image("assets/avatars/lgAvatar/10.png"), new Image("assets/avatars/lgAvatar/11.png"),
            new Image("assets/avatars/lgAvatar/12.png"), new Image("assets/avatars/lgAvatar/13.png"), new Image("assets/avatars/lgAvatar/14.png"), new Image("assets/avatars/lgAvatar/15.png")};

    private Image sneak = new Image("assets/avatars/skillCards/scoutCard.png");
    private Image smasher = new Image("assets/avatars/skillCards/smasherCard.png");
    private Image summoner = new Image("assets/avatars/skillCards/summonerCard.png");

    protected int i = 0;
    ToggleGroup skills = new ToggleGroup();

    private Scene scene;
    private static String skillSelect = "";

    public void initialize(URL url, ResourceBundle bundle){

        base.setBackground(new Background(new BackgroundImage(new Image("assets/backdrops/mainMenu.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        base.setPadding(new Insets(32));
        avatar.setImage(avatars[i]);

        scout.setOnAction( event -> {
            skillsCard.setImage(sneak);
            skillSelect = "sneak";
        });

        warrior.setOnAction( event -> {
            skillsCard.setImage(smasher);
            skillSelect = "smasher";
        });

        healer.setOnAction( event -> {
            skillsCard.setImage(summoner);
            skillSelect = "summoner";

        });

        skills.getToggles().addAll(scout, warrior, healer);

        skillsCard.setImage(sneak);
        scout.setSelected(true);
    }

    @FXML private void leftCycle(){
        if(i != 0)
            i--;
        else
            i = avatars.length - 1;
        avatar.setImage(avatars[i]);
    }

    @FXML private void rightCycle(){
        if(i != avatars.length - 1)
            i++;
        else
            i = 0;
        avatar.setImage(avatars[i]);
    }

    @FXML private void startGame() throws IOException {
        //TODO: initialize new game
        this.showScene();
    }

    @FXML protected void setAvatar(String skill){
        //TODO: parse in avatar object into game loader
        //ToDo: select factory based on string?
    }

    private void showScene() throws IOException {
        Platform.runLater(() -> {
            Stage stage = (Stage) base.getScene().getWindow();
            stage.setResizable(true);
            stage.setWidth(1080);
            stage.setHeight(720);

            stage.setOnCloseRequest((WindowEvent e) -> {
                Platform.exit();
                System.exit(0);
            });
            stage.setScene(this.scene);
            stage.setMinWidth(800);
            stage.setMinHeight(300);
            //ResizeHelper.addResizeListener(stage);
            stage.centerOnScreen();
        });
    }
}
