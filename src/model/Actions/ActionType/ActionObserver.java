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
        name = "projectile";
        coolDown = 0;
    }

    @Override
    public void update(ArrayList<Point> points, String name) {
        this.points = points;
        this.name = name;
        coolDown = 30;
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

    public boolean getPoints(){
        if(coolDown > 0)
            return true;
        return false;
    }
}
