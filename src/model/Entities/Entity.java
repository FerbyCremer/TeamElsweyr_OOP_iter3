package model.Entities;

import controller.Handlers.BringOutYourDeadHandler;
import model.*;
import model.Inventory.Equipment;
import model.Inventory.Inventory;
import model.Items.Takeable.Takeable;
import model.Map.Direction;
import model.Map.Terrain;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements EntityVisitable, EntityVisitor  {
	protected EntityStats stats;
	protected Inventory inventory;
	private ArrayList<Terrain> terrains;
	private ArrayList<Updateable> observers;
	private String name;
	private BringOutYourDeadHandler deadHandler;
		
	public Entity(EntityStats entityStats, BringOutYourDeadHandler deadHandler) {
		this.stats = entityStats;
		this.inventory = new Inventory(stats);
		this.terrains = new ArrayList<>();
		this.deadHandler = deadHandler;
	}
		
	//Changes the entity's speed based on whether or not they are facing the right direction
	public void move(Direction direction) {
		if(direction == stats.getFacingDirection()) {
			stats.modifyCurrentSpeed(stats.getMaxSpeed());
		}
			
		else {
			stats.setFacingDirection(direction);
		}
	}

	public void addToInventory(Takeable item){
		inventory.addItem(item);
	}
		
	// Changes the entity's inventory, mainly for load game
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
		
	//updateHealth is a wrapper method that tells EntityStats to modify the entity's health
	public void updateHealth(int healthChange) {
		stats.modifyHealth(healthChange);
        if (!stats.isAlive()){
            deadHandler.notifyEntityDead(this);
        }
	}

		
	//updateSpeed tells the EntityStats class to modify the entiy's speed
	public void updateCurrentSpeed(int speed) {
		stats.modifyCurrentSpeed(speed);
	}
		
	//getCurrentSpeed returns the entity's speed
	public int getCurrentSpeed() {
		return stats.getCurrentSpeed();
	}
	
	//getMaxSpeed returns the entity's maxSpeed
	public int getMaxSpeed() {
		return stats.getMaxSpeed();
	}
		
	//updateMaxSpeed tells the EntityStats class to modify the entiy's max speed
	public void updateMaxSpeed(int maxSpeed) {
		stats.modifyMaxSpeed(maxSpeed);
	}

    public String getName() {
        return name;
    }


	@Override
	public void accept(EntityVisitor entityVisitor) {
		entityVisitor.visit(this);
	}

	@Override
	public void visit(Entity entity) {

	}
	
	public void setFacingDirection(Direction direction){
			stats.setFacingDirection(direction);
	}

    public Direction getDirection(){
			return stats.getFacingDirection();
		}
}

