package model.Entities;

import model.*;
import model.Inventory.Equipment;
import model.Inventory.Inventory;
import model.Items.Takeable.Takeable;
import model.Map.Direction;
import model.Map.Terrain;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements EntityVisitable, EntityVisitor {
	protected EntityStats stats;
	protected Inventory inventory;
	private ArrayList<Terrain> terrains;
	protected ArrayList<Updateable> observers;
	private String name;
		
	public Entity() {
		stats = new EntityStats();
		inventory = new Inventory(stats);
		terrains = new ArrayList<Terrain>();
	}
		
	//Changes the entity's speed based on whether or not they are facing the right direction
	public void move(Direction direction) {
		if(direction == stats.getFacingDirection()) {
			stats.modifyCurrentSpeed(stats.getMaxSpeed());
		}
			
		else {
			stats.setFacingDirection(direction);
		}
		execute();
	}

	public void addToInventory(Takeable item){
		inventory.addItem(item);
		execute();
	}
		
	// Changes the entity's inventory, mainly for load game
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
		execute();
	}
		
	//updateHealth is a wrapper method that tells EntityStats to modify the entity's health
	public void updateHealth(int healthChange) {
		stats.modifyHealth(healthChange);
		execute();
	}

		
	//updateSpeed tells the EntityStats class to modify the entiy's speed
	public void updateCurrentSpeed(int speed) {
		stats.modifyCurrentSpeed(speed);
		execute();
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
		execute();
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
			execute();
	}

    public Direction getDirection(){
			return stats.getFacingDirection();
		}

	public void add(Updateable updateable){
		observers.add(updateable);
	}

	protected void execute(){
		for(Updateable updateable: observers){
			updateable.update();
		}
	}

	public int getHealth(){
		return stats.getHealth();
	}

	public int getLevel(){
		return stats.getLevel();
	}

	public int getExp(){
		return stats.getExperience();
	}
}

