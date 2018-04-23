package controller.ViewControllers;

import controller.LoadGame.GameLoader;
import controller.LoadGame.GameSaver;
import controller.MapControllers.WorldController;
import controller.ViewControllers.test.ChoiceCell;
import controller.ViewControllers.test.ChoiceModel;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import view.ZoneView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.util.ResourceBundle;

public class AvatarController implements Initializable {

    @FXML ImageView avatar;
    @FXML ToggleButton scout;
    @FXML ToggleButton warrior;
    @FXML ToggleButton healer;
    @FXML ImageView skillsCard;
    @FXML private BorderPane base;

    private GameLoader gameLoader;
    private GameSaver gameSaver;

    protected Image[] avatars = {new Image("assets/avatars/lgAvatar/1.png"), new Image("assets/avatars/lgAvatar/2.png"), new Image("assets/avatars/lgAvatar/3.png"),
            new Image("assets/avatars/lgAvatar/4.png"), new Image("assets/avatars/lgAvatar/5.png"), new Image("assets/avatars/lgAvatar/6.png"),new Image("assets/avatars/lgAvatar/7.png"),
            new Image("assets/avatars/lgAvatar/8.png"), new Image("assets/avatars/lgAvatar/9.png"), new Image("assets/avatars/lgAvatar/10.png"), new Image("assets/avatars/lgAvatar/11.png"),
            new Image("assets/avatars/lgAvatar/12.png"), new Image("assets/avatars/lgAvatar/13.png"), new Image("assets/avatars/lgAvatar/14.png"), new Image("assets/avatars/lgAvatar/15.png")};

    protected String[] SMavatars = {"1i", "2i", "3i", "4i", "5i", "6i", "7i", "8i", "9i", "10i", "11i", "12i", "13i", "14i", "15i"};

    private Image sneak = new Image("assets/avatars/skillCards/scoutCard.png");
    private Image smasher = new Image("assets/avatars/skillCards/smasherCard.png");
    private Image summoner = new Image("assets/avatars/skillCards/summonerCard.png");

    protected int i = 0;
    ToggleGroup skills = new ToggleGroup();

    private Scene scene;
    private static String skillSelect = "";

    private KeyCode up = KeyCode.W;

    private KeyCode down = KeyCode.D;
    //ZoneView zone = new ZoneView();

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

       Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/GameViewport.fxml"));
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/GameViewport.fxml"),
                    ResourceBundle.getBundle("view.GameViewport"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*Parent window;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/GameViewport.fxml"));
*/
       // root = (BorderPane) fxmlLoader.load();
        this.scene = new Scene(root);
        this.showScene(fxmlLoader);
    }

    @FXML protected void setAvatar(String skill){
        //TODO: parse in avatar object into game loader
        //ToDo: select factory based on string?
    }

    private void showScene(FXMLLoader fxmlLoader) throws IOException {
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
            javafx.scene.canvas.Canvas canvas = new Canvas(1000, 1000);

            BorderPane borderPane = new BorderPane();
            Pane p = new Pane();
           // p.setPrefWidth(400);
            borderPane.setCenter(p);


            p.getChildren().add(canvas);

            //borderPane.positionInArea(p, 300,300,200,200,20, new Insets(0), HPos.CENTER, VPos.CENTER, false);

            ListView<ChoiceModel> choicesView = new ListView<>();
                    choicesView.setCellFactory(new Callback<ListView<ChoiceModel>, ListCell<ChoiceModel>>()
            {
                public ListCell<ChoiceModel> call(ListView<ChoiceModel> p)
                {
                    return new ChoiceCell();
                }
            });
            System.out.println("akdjfl;asdjfl;asjdfl;jasdl;fjasd");
            choicesView.setItems(FXCollections.observableArrayList
                    (

                            new ChoiceModel("Tiger", true),
                            new ChoiceModel("Shark", false),
                            new ChoiceModel("Bear", false),
                            new ChoiceModel("Wolf", true)
                    ));

            Pane pane = new Pane(choicesView);
            //pane.getChildren().add(choicesView);
            borderPane.setRight(pane);
            root.getChildren().add(borderPane);
            canvas.setFocusTraversable(true);


            //camera stuff
            Camera camera = new PerspectiveCamera(false);
            mainScene.setCamera(camera);
            Group cameraGroup = new Group();
            cameraGroup.getChildren().add(camera);
            root.getChildren().add(cameraGroup);

            //GameObserver gameObserver = fxmlLoader.getController();
            //gameObserver.setCanvas(root);

//            gameObserver.setScene(mainScene);

            gameLoader = new GameLoader(canvas,  camera);
            WorldController theworld = gameLoader.load();
            gameLoader.initializeKeyController(mainScene);
            gameSaver = new GameSaver(theworld);
            gameLoader.initializeKeyController(mainScene);

            theworld.setPlayerName(SMavatars[i]);

            theworld.runGame();
            mainStage.show();
        });
    }
}
