package model.Map.Zone.TileRelatedClasses;

import model.Entities.Entity;
import model.Map.Direction;

public class River {
    private int flowRate;
    private Direction direction;

    public River(int flowRate, Direction direction) {
        this.flowRate = flowRate;
        this.direction = direction;
    }

    public void apply(Entity entity){

    }
}
