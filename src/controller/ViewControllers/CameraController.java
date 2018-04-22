package controller.ViewControllers;

import javafx.scene.Camera;

import java.awt.*;

public class CameraController{
    private Camera camera;
    private int cameraX = 0;
    private int cameraY = 0;
    private Point playerPOS;
    private int hexWidth = 92;
    private int hexHeight = 80;
    private double screenHeight;
    private double screenWidth;

    public CameraController(Camera _camera, double screenHeight, double screenWidth){
        this.camera = _camera;
        playerPOS = new Point(0, 0);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

    }

    //TODO actually center on the players coordinates
    public void resetCameraOnPlayer(){
        camera.relocate(playerPOS.getX(), playerPOS.getY());
    }

    public void moveCameraNorth(){
        cameraY -= hexHeight;
        camera.relocate(0, cameraY);
    }

    public void moveCameraNorthEast(){
        cameraY -= hexHeight;
        cameraX += hexWidth;
        camera.relocate(cameraX, cameraY);
    }

    public void moveCameraNorthWest(){
        cameraX -= hexWidth;
        cameraY -= hexHeight;
        camera.relocate(cameraX, cameraY);
    }
    public void moveCameraSouth(){
        cameraY += hexHeight;
        camera.relocate(cameraX, cameraY);
    }

    public void moveCameraSouthEast(){
        cameraX += hexWidth;
        cameraY += hexHeight;
        camera.relocate(cameraX, cameraY);
    }

    public void moveCameraSouthWest(){
        cameraX -= hexWidth;
        cameraY += hexHeight;
        camera.relocate(cameraX, cameraY);
    }

    public void setPlayerPOS(Point p){
        double x = (hexWidth*.75) * (3/2) * p.getX();
        double y = (hexWidth/2) * Math.sqrt(3) * (p.getY() - 0.5 * (p.getX()%2)) + 40;



       // System.out.println(x + "  " + y);


        playerPOS.setLocation(x, y);


    }

    private void centerCamera(double x, double y){


    }

}
