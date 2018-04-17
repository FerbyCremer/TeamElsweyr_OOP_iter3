package model.Entities;

import model.*;
import model.Inventory.Equipment;
import model.Inventory.Inventory;
import model.Map.Direction;
import model.Map.Terrain;

import java.util.List;

public abstract class Entity {
    protected EntityStats entityStats;
    private Inventory inventory;
    private List<Terrain> terrains;
    private Equipment equipment;
    private List<Updateable> observers;

    public Entity(){

    }

    public void move(Direction direction){

    }

    public void updateHealth(int amount){

    }
}
