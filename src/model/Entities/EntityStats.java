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
	
	// Constructors
	public EntityStats() {
		maxHealth = 100;
		currentHealth = 100;
		level = 1;
		defense = 10;
		detectRange = 10;
		maxSpeed = 5;
		currentSpeed = 0;

		//facingDirection = Direction.N;
	}
	
	public EntityStats(int maxHealth, int currentHealth, int level, int experience, int defense, int detectRange, int currentSpeed) {
		this.maxHealth = maxHealth;
		this.currentHealth = currentHealth;
		this.level = level;
		this.experience = experience;
		this.defense = defense;
		this.detectRange = detectRange;
		this.currentSpeed = currentSpeed;
		this.facingDirection = Direction.N;
	}
	
	//Health
	public void modifyHealth(int delta) {
		if(currentHealth + delta < 0) {
			currentHealth = 0;
			return;
		}
		
		if(currentHealth + delta > maxHealth) {
			currentHealth = maxHealth;
			return;
		}
		
		currentHealth += delta;
	}
	
	public int getHealth() {
		return currentHealth;
	}

	/*public void modifyHealth(int delta, Time time) {
		
	}*/
	
	public void modifyMaxHealth(int delta) {
		if(maxHealth + delta < 0) {
			maxHealth = 0;
			return;
		}
		
		maxHealth += delta;
	}
	
	// Defense
	public void modifyDefense(int delta) {
		if(defense + delta < 0) {
			defense = 0;
			return;
		}
		
		defense += delta;
	}
	
	public int getDefense() {
		return defense;
	}
	
	// Level
	public void levelUp() {
		++level;
	}
	
	public int getLevel() {
		return level;
	}
	
	// Experience
	public void modifyExperience(int delta) {
		if(experience + delta < 0) {
			experience = 0;
			return;
		}
		
		if(experience + delta >= 100) {
			experience = 100 - delta;
			
			levelUp();
			return;
		}
		
		experience += delta;
	}

	//Speeds
	public void modifyCurrentSpeed(int delta) {
		if(currentSpeed + delta < 0) {
			currentSpeed = 0;
			return;
		}
		
		currentSpeed += delta;
	}

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void modifyMaxSpeed(int delta) {
		if(maxSpeed + delta < 0) {
			maxSpeed = 0;
			return;
		}
		
		maxSpeed += delta;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	// Direction
	public void setFacingDirection(Direction direction) {
		facingDirection = direction;
	}

	public Direction getFacingDirection() {
		return facingDirection;
	}

	public boolean isAlive(){
	    return currentHealth > 0;
    }
}
