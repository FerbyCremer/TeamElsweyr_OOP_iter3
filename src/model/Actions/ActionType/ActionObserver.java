package model.Actions.ActionType;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ActionObserver implements ActionInterface {
    private String name;
    private ArrayList<Point> points;
    private int coolDown;
    public ActionObserver(){
        points = new ArrayList<Point>();
        name = "explosion";
        coolDown = 0;
    }

    @Override
    public void update(ArrayList<Point> points, String name) {
        this.points = points;
       // this.name = name;
        coolDown = 1000;
    }

    @Override
    public ArrayList<Point> getActionLocation() {
        --coolDown;
        return points;
    }

    @Override
    public String getActionName() {
        if(coolDown>=0)
           --coolDown;
        return name;
    }

    public void clear(){
        points.clear();
        name = null;
    }

    public boolean getPoints(Point point){
        if(points.contains(point)) {
            if (coolDown > 0)
                return true;
        }
        return false;
    }
}
