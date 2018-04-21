import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RunGame extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("view/MainMenu.fxml"));
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Team Elsweyr OOP Iteration 3: The Mewrchants of Vemice");

        Scene mainScene = new Scene(root);
        mainScene.setRoot(root);
        stage.setResizable(true);
        stage.setScene(mainScene);
        stage.show();
        stage.setOnCloseRequest( e -> Platform.exit());
    }

    public static void main(String[] args) { launch(args); }

    public static Stage getPrimaryStage() { return primaryStage; }

}
