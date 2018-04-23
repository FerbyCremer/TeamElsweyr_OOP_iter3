package view;

import controller.KeyControllers.KeyCommands.Observe;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSet;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSetFTDRTIE;
import javafx.fxml.FXML;
import javafx.scene.Camera;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Actions.Action;
import model.Actions.ActionType.ActionInterface;
import model.Actions.ActionType.ActionObserver;
import model.Effect.EntityEffect.ObserveObserver;

import java.awt.*;
import java.util.ArrayList;

public class ZoneView {

    private DecalSet decalSet;
    private SpriteLoader sprites;

    //TODO remove this stuff

    @FXML
    private Canvas canvas;
    private GraphicsContext gc;

    private double hexHeight;
    private double hexWidth;

    private double screenWidth;
    private double screenHeight;

    Camera camera;

    double cameraX;
    double cameraY;
    ObserveObserver observeObserver;
    ActionInterface actionInterface;

   public ZoneView(Canvas canvas, Camera camera){
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        hexHeight = 80;
        hexWidth = 92;
        decalSet = new DecalSetFTDRTIE();
        sprites = new SpriteLoader();
        this.camera = camera;

        screenWidth = camera.getParent().getScene().getWindow().getWidth();
        screenHeight = camera.getParent().getScene().getWindow().getHeight();
    }

    public void setActionInterface(ActionInterface actionInterface) {
        this.actionInterface = actionInterface;
    }

    public void addObserver(ObserveObserver observeObserver){
        this.observeObserver = observeObserver;
    }

    public void renderGrid(){
        focusPlayer();
        double hexX = 0;
        double hexY = hexHeight/2;

        //TODO change x and y to getXDIM and getYDIM via DecalSetOAEUFHEI
        for(int y = 0; y < decalSet.getYDim(); y++){
            for(int x = 0; x < decalSet.getXDim(); x++){
            ArrayList<String> tempList = decalSet.getTileContents(new Point(x, y));
                for (String s : tempList) {
                    gc.drawImage(sprites.getImage(s), hexX, hexY, hexWidth, hexHeight);
                }
                if(actionInterface.getPoints(new Point(x,y))) {
                    gc.drawImage(sprites.getImage(actionInterface.getActionName()), hexX, hexY, hexWidth, hexHeight);
                }
                if(observeObserver != null) {
                    if (observeObserver.hasText()) {
                        if (observeObserver.getPoint().x == x && observeObserver.getPoint().y == y) {
                            gc.fillText(observeObserver.getText(), hexX, hexY);
                        }
                    }
                }
                hexY+= hexHeight;
            }
            //move the next column the correct amount
            hexX += hexWidth*.75;

            //set the height of the next column, shift down when odd
            if(y % 2 == 0)
                hexY = 0;
            else
                hexY = hexHeight / 2;
        }
    }

    public void updateZoneView(DecalSet decalSet){
        this.decalSet = decalSet;
    }

    public void renderEffects(){
//        pointList = decalSet.getEffectPoints();
//        for (Point p: pointList) {
//            double x;
//            double y;
//            x = (hexWidth*.75) * (3/2) * p.getX();
//            y = (hexWidth/2) * Math.sqrt(3) * (p.getY() - 0.5 * (p.getX()%2));
//            y += 80/2;
//            //System.out.println(x + "   " + y);
//            gc.drawImage(img3, x, y, hexWidth, hexHeight);
//        }
//        //pointList.clear();
    }

    public void focusPlayer(){
       double x = (hexWidth/2) * (3/2) * ((DecalSetFTDRTIE)decalSet).getPlayerY();
       double y = (hexWidth/2) * Math.sqrt(3) * (((DecalSetFTDRTIE)decalSet).getPlayerX() - 0.5 * (((DecalSetFTDRTIE)decalSet).getPlayerY()%2)) + 40;

       centerCamera(x, y);
    }

    public void centerCamera(double x, double y){
       x -= screenWidth/2;
       y -= screenHeight/2;
       camera.relocate(x, y);
    }
}
