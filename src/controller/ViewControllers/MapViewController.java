package controller.ViewControllers;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class MapViewController extends Canvas {

    /*private void showScene() throws IOException {
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
    }*/
}
