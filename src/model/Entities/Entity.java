package model.Entities;

import controller.Handlers.BringOutYourDeadHandler;
import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;
import model.*;
import model.Inventory.Equipment;
import model.Inventory.Inventory;
import model.Items.Takeable.Takeable;
import model.Map.Direction;
import model.Map.Terrain;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements EntityVisitable, EntityVisitor, Saveable {

    protected EntityStats stats;
    protected Inventory inventory;
    protected List<Terrain> terrains;
    private List<Updateable> observers;
    private String name;
    private BringOutYourDeadHandler deadHandler;

//    public Entity(EntityStats entityStats, BringOutYourDeadHandler deadHandler) {
//        this.stats = entityStats;
//        this.inventory = new Inventory(stats);
//        this.terrains = new ArrayList<>();
//        this.deadHandler = deadHandler;
//    }

    //Load Constructor
    public Entity(EntityStats entityStats, Inventory inventory, List<Terrain> terrains, String name, BringOutYourDeadHandler deadHandler) {
        this.stats = entityStats;
        this.inventory = inventory;
        this.terrains = terrains;
    	this.name = name;
    	this.deadHandler = deadHandler;

    	//TODO observers
        observers = new ArrayList<>();
    }



    //updateHealth is a wrapper method that tells EntityStats to modify the entity's health
    public void updateHealth(int healthChange) {
        stats.modifyHealth(healthChange);
        if (!stats.isAlive()) {
            deadHandler.notifyEntityDead(this);
        }
        execute();
    }


    //getStats returns the entity stats
    public EntityStats getStats() {
        return stats;
    }



		
	//Changes the entity's speed based on whether or not they are facing the right direction
	public void move(Direction direction) {
		if(direction == getDirection()) {
			stats.setCurrentSpeed(stats.getMaxSpeed());
		}
			
		else {
			stats.setFacingDirection(direction);
            System.out.println("Facing: " + getDirection());
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
		

	public void setCurrentSpeed(int currentSpeed) {
		this.stats.setCurrentSpeed(currentSpeed);
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

	public void setDetectRange(int detect){
	    stats.setDetectRange(detect);
    }

    public int getDetectRange(){
	    return stats.getDetectRange();
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

	@Override
	public void visit(Mount mount){};

    @Override
	public void visit(Player player){};

    public Direction getDirection() {
        return stats.getFacingDirection();
    }


    public List<Terrain> getTerrains() {
        return terrains;
    }


    public void setFacingDirection(Direction direction){
			stats.setFacingDirection(direction);
			execute();
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setStolen() { inventory.setStolen();}

    public Takeable giveStolen(){ return inventory.giveStolen();}


	@Override
	public String accept(SaveVisitor saveVisitor){
    	return saveVisitor.saveEntity(this);
	}
}

