package model.Entities;

import model.Map.Terrain;

import java.util.List;

public class Mount extends Entity {

    private List<Terrain> terrains;

    public Mount(int speed){
    	stats.setMaxSpeed(speed);
    }

    public int getSpeed(){
        return stats.getMaxSpeed();
    }

    public List<Terrain> getPassable(){
        return terrains;
    }
}
