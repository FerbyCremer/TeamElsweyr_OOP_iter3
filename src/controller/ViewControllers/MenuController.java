package controller.ViewControllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML private BorderPane base;

    private Scene scene;

    public void initialize(URL u, ResourceBundle b){
        base.setBackground(new Background(new BackgroundImage(new Image("assets/backdrops/mainMenu.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
    }

    @FXML private void startNewGame() throws IOException{
        Parent window;
        FXMLLoader fmxlLoader = new FXMLLoader(getClass().getResource("/view/AvatarCreator.fxml"));
        window = (BorderPane) fmxlLoader.load();

        this.scene = new Scene(window);

        this.showScene();
    }

    @FXML private void loadGame() throws IOException {
        Parent window;
        FXMLLoader fmxlLoader = new FXMLLoader(getClass().getResource("/view/GameViewport.fxml"));
        window = (BorderPane) fmxlLoader.load();

        this.scene = new Scene(window);
        //TODO need two versions???
        this.showScene();
    }

    @FXML private void keyConfig() throws IOException {
        Parent window;
        FXMLLoader fmxlLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/KeyConfiguring.fxml"));
        window = (BorderPane) fmxlLoader.load();

        this.scene = new Scene(window);
        //TODO is there something missing???
        this.showScene();
    }

    @FXML private void resume() throws IOException{
        Parent window;
        FXMLLoader fmxlLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/GameViewport.fxml"));
        window = (BorderPane) fmxlLoader.load();

        this.scene = new Scene(window);

        //TODO: set it to resume back to same spot when menu was opened

        this.showScene();
    }

    @FXML private void saveGame() {
        //TODO: save game function goes HERE
    }

    @FXML private void exit(){
        System.exit(0);
    }

    private void showScene() throws IOException {
        Platform.runLater( () -> {
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
