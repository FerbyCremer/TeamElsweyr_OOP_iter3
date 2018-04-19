package model.Map.Zone.TileRelatedClasses;

import model.Entities.Entity;
import model.Map.Direction;

public class River {
    private int flowRate;
    private Direction direction;
    private String name;

    public River(int flowRate, Direction direction, String name) {
        this.flowRate = flowRate;
        this.direction = direction;
        this.name = name;
    }

    public void apply(Entity entity){

    }

    public String getName() {
        return name;
    }
}
