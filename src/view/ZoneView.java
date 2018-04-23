package view;

import controller.MapControllers.FogOfWarRelatedClasses.DecalSetFTDRTIE;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.awt.*;
import java.util.ArrayList;

public class ZoneView {

   DecalSetFTDRTIE s;

    String workingDirectory = "file:" + System.getProperty("user.dir");

    Image img1 = new Image(workingDirectory + "/src/assets/volcano.png");
    Image img2 = new Image(workingDirectory + "/src/assets/grass.png");
    Image img3 = new Image(workingDirectory + "/image/mountain1.png");
    Image fog = new Image(workingDirectory + "/image/fog.png");
    Image nonVisible = new Image(workingDirectory + "/image/nonVisible.png");

    //TODO remove this stuff

    @FXML
    Canvas canvas;
    GraphicsContext gc;

    double hexHeight;
    double hexWidth;

    double cameraX;
    double cameraY;

   public ZoneView(Canvas canvas){
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        hexHeight = 80;
        hexWidth = 92;
        s = new DecalSetFTDRTIE();


    }

    public void renderGrid(){
        /*
          hexX and hexY are the starting position of the grid
         */
        double hexX = 0;
        double hexY = hexHeight/2;
        /*
        loop through the tile set and print the provided strings
         */
        System.out.println("xdim " + s.getXDim() + " ydmin " + s.getYDim());

        //TODO change x and y to getXDIM and getYDIM via DecalSetOAEUFHEI
        for(int x = 0; x < 30; x++){
            for(int y = 0; y < 30; y++){
            //ArrayList<String> tempList = s.getTileContents(new Point(x, y));
                //for (String s : tempList) {
                    if(x % 2 == 0){
                        gc.drawImage(img1, hexX, hexY, hexWidth, hexHeight);
                    }
                    else {
                        gc.drawImage(img2, hexX, hexY, hexWidth, hexHeight);
                    }
                //}
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
