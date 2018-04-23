package controller.ViewControllers;

import controller.LoadGame.GameLoader;
import controller.LoadGame.GameSaver;
import controller.MapControllers.WorldController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuObserver implements Initializable {

    @FXML private BorderPane base;

    private Scene scene;
    private GameLoader gameLoader;
    private GameSaver gameSaver;

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/GameViewport.fxml"));
        this.showGame(fxmlLoader);

        window = (BorderPane) fxmlLoader.load();
        this.scene = new Scene(window);
        //TODO need two versions???
    }

    @FXML private void keyConfig() throws IOException {
        Parent window;
        FXMLLoader fmxlLoader = new FXMLLoader(getClass().getResource("/view/KeyConfiguring.fxml"));
        window = (TabPane) fmxlLoader.load();

        this.scene = new Scene(window);
        //TODO is there something missing???
        this.showScene();
    }

    @FXML private void resume() throws IOException{
        Parent window;
        FXMLLoader fmxlLoader = new FXMLLoader(getClass().getResource("/view/GameViewport.fxml"));
        window = (BorderPane) fmxlLoader.load();

        this.scene = new Scene(window);

        //TODO: set it to resume back to same spot when menu was opened

        //this.showGame();
    }




    @FXML private void saveGame() throws IOException {
        //TODO: save game function goes HERE
        this.showScene();
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

    private void showGame(FXMLLoader fxmlLoader) throws IOException {
        Platform.runLater(() -> {
            Stage mainStage = (Stage) base.getScene().getWindow();
            mainStage.setTitle("Team Elsweyr OOP Iteration 3: The Mewrchants of Vemice");
            mainStage.setMaximized(true);

            Group root = new Group();
            Scene mainScene = new Scene(root);
            mainStage.setScene( mainScene );
            mainStage.setOnCloseRequest((WindowEvent e) -> {
                Platform.exit();
                System.exit(0);
            });

            javafx.scene.canvas.Canvas canvas = new Canvas(2500, 2500);

            //gameSaver.save();

            root.getChildren().add(canvas);
            canvas.setFocusTraversable(true);

            //camera stuff
            Camera camera = new PerspectiveCamera(false);
            mainScene.setCamera(camera);
            Group cameraGroup = new Group();
            cameraGroup.getChildren().add(camera);
            root.getChildren().add(cameraGroup);


            GameObserver gameObserver = fxmlLoader.getController();

            gameLoader = new GameLoader(canvas, gameObserver);
            WorldController theworld = gameLoader.load();
            gameSaver = new GameSaver(theworld);

            theworld.runGame();
            mainStage.show();
        });
    }

}
