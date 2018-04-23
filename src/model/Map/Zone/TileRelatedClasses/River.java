package model.Map.Zone.TileRelatedClasses;

import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;
import model.Entities.Entity;
import model.Map.Direction;

public class River implements Saveable {
    private int flowRate;
    private Direction direction;
    private String name;

    public River(int flowRate, Direction direction) {
        this.flowRate = flowRate;
        this.direction = direction;
        this.name = "River";
    }

    public Direction apply(Entity entity){
        int entitySpeed = entity.getCurrentSpeed();
        Direction entityDirection = entity.getDirection();

        //could be errors that my 0 is up and not to the right, but shouldnt matter
        double entityRadians = Math.toRadians(entityDirection.getAngle());
        int vectorX = (int) (entitySpeed*Math.cos(entityRadians));
        int vectorY = (int) (entitySpeed*Math.sin(entityRadians));
        System.out.println("vectorX = " + vectorX);
        System.out.println("vectorY = " + vectorY);

        double riverRadians = Math.toRadians(direction.getAngle());
        int riverVectorX = (int) (flowRate*Math.cos(riverRadians));
        int riverVectory = (int) (flowRate*Math.sin(riverRadians));

        int sumX = vectorX + riverVectorX;
        int sumY = vectorY + riverVectory;

        double sumSpeed = Math.pow(sumX, 2) + Math.pow(sumY,2);
        int newEntitySpeed = (int) Math.sqrt(sumSpeed);
        System.out.println("speed = " + sumSpeed);
        System.out.println("SUMX " + sumX);
        System.out.println("SUMY " + sumY);
        int degrees = (int) Math.toDegrees(Math.atan2((double)sumY, (double)sumX));
        System.out.println("degrees = " + degrees);
        entity.setCurrentSpeed(newEntitySpeed);
        return Direction.getDirectionClosest(degrees);
    }

    public int getFlowRate() {
        return flowRate;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getName() {
        return name;
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveRiver(this);
    }
}
