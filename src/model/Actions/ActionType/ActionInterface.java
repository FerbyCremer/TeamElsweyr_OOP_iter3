package model.Actions.ActionType;

import java.awt.*;
import java.util.ArrayList;

public interface ActionInterface {
    void update(ArrayList<Point> points, String name);
    ArrayList<Point> getActionLocation();
    String getActionName();
    public boolean getPoints(Point point);
}
