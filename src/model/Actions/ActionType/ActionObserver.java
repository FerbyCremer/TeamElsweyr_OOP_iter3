package model.Actions.ActionType;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ActionObserver implements ActionInterface {
    private String name;
    private ArrayList<Point> points;

    public ActionObserver(){
        points = new ArrayList<Point>();
    }

    @Override
    public void update(ArrayList<Point> points, String name) {
        this.points = points;
        this.name = name;
    }

    @Override
    public ArrayList<Point> getActionLocation() {
        return points;
    }

    @Override
    public String getActionName() {
        return name;
    }

    public void clear(){
        points.clear();
        name = null;
    }
}
