package model.Entities;

import model.Map.Terrain;

import java.util.List;

import controller.Handlers.BringOutYourDeadHandler;

public class Mount extends Entity {

    private List<Terrain> terrains;

    public Mount(int speed, EntityStats stats, BringOutYourDeadHandler deadHandler){
    	super(stats, deadHandler);
    	stats.setMaxSpeed(speed);
    }

    public int getSpeed(){
        return stats.getMaxSpeed();
    }

    public List<Terrain> getPassable(){
        return terrains;
    }
}
