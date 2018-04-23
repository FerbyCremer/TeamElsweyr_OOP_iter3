package view;

import controller.MapControllers.FogOfWarRelatedClasses.DecalSet;
import controller.MapControllers.FogOfWarRelatedClasses.DecalSetFTDRTIE;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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

    double cameraX;
    double cameraY;

   public ZoneView(Canvas canvas){
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        hexHeight = 80;
        hexWidth = 92;
        decalSet = new DecalSetFTDRTIE();
        sprites = new SpriteLoader();
    }

    public void renderGrid(){

        double hexX = 0;
        double hexY = hexHeight/2;

        //TODO change x and y to getXDIM and getYDIM via DecalSetOAEUFHEI
        for(int x = 0; x < decalSet.getXDim(); x++){
            for(int y = 0; y < decalSet.getYDim(); y++){
            ArrayList<String> tempList = decalSet.getTileContents(new Point(x, y));
                for (String s : tempList) {
                    gc.drawImage(sprites.getImage(s), hexX, hexY, hexWidth, hexHeight);
                }
                hexY+= hexHeight;
            }
            //move the next column the correct amount
            hexX += hexWidth*.75;

            //set the height of the next column, shift down when odd
            if(x % 2 == 0)
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

}
