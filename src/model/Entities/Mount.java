package model.Entities;

import model.Inventory.Inventory;
import model.Map.Terrain;

import java.util.List;

import controller.Handlers.BringOutYourDeadHandler;

public class Mount extends Entity {
    public Mount(EntityStats stats, BringOutYourDeadHandler deadHandler, Inventory inventory, List<Terrain> terrains, String name){
    	super(stats, inventory, terrains, name, deadHandler);
    }

    public int getSpeed(){
        return stats.getMaxSpeed();
    }

    public List<Terrain> getPassable(){
        return super.getTerrains();
    }
}
