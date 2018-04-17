package model.Entities;

import model.Map.Direction;

public class EntityStats {
    private int maxHealth;
    private int currentHealth;
    private int level;
    private int experience;
    private int defense;
    private int detectRange;
    private int maxSpeed;
    private int currentSpeed;
    private Direction facingDirection;

    private int visibleRadius;

    public EntityStats(){

    }

    public int getCurrentSpeed(){
        return currentSpeed;
    }
}
