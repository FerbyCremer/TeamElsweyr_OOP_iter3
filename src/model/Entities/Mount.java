package model.Entities;

import model.Map.Terrain;

import java.util.List;

public class Mount extends Entity {

    private List<Terrain> terrains;

    public Mount(){}

    public int getSpeed(){
        return entityStats.getCurrentSpeed();
    }

    public List<Terrain> getPassable(){
        return terrains;
    }
}
