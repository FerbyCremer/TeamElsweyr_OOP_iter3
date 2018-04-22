import controller.LoadGame.GameLoader;
import controller.MapControllers.WorldController;
import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;


public class Main extends Application{


    private Stage mainStage;
    private Scene mainScene;


    private final long ticksPerSecond = 2;

    @Override
    public void start(Stage theStage) {
        /*
        Scene, canvas and camera setup
         */
        mainStage = theStage;
        mainStage.setTitle("bad game name here");
        theStage.setMaximized(true);

        Group root = new Group();
        mainScene = new Scene(root);
        theStage.setScene( mainScene );

        Canvas canvas = new Canvas(2500, 2500);

        root.getChildren().add(canvas);
        canvas.setFocusTraversable(true);

        //camera stuff
        Camera camera = new PerspectiveCamera(false);
        mainScene.setCamera(camera);
        Group cameraGroup = new Group();
        cameraGroup.getChildren().add(camera);
        root.getChildren().add(cameraGroup);

        GameLoader loader = new GameLoader(canvas);
        WorldController theworld = loader.load();


        theworld.runGame();
        theStage.show();

    }



    public static void main(String[] args) {


        launch(args);
    }

}
