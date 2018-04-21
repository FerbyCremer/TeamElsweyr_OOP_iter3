package model.Entities;

import model.Map.Terrain;

import java.util.List;

import controller.Handlers.BringOutYourDeadHandler;

public class Mount extends Entity {
    public Mount(EntityStats stats, BringOutYourDeadHandler deadHandler){
    	super(stats, deadHandler);
    }

    public int getSpeed(){
        return stats.getMaxSpeed();
    }

    public List<Terrain> getPassable(){
        return super.getTerrains();
    }
}
