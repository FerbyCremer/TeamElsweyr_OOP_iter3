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
	private Direction derivedDirection;
	
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
	
	public void modifyHealth(int delta) {
		currentHealth += delta;
		
		if(currentHealth < 0) {
			currentHealth = 0;
		}
		
		if(currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
	}
	
	public int getHealth() {
		return currentHealth;
	}
	
	/*public void modifyHealth(int delta, Time time) {
		
	}*/
	
	public void modifyMaxHealth(int delta) {
		maxHealth += delta;
		
		if(maxHealth < 0) {
			maxHealth = 0;
		}
	}
	
	public void modifyDefense(int delta) {
		defense += delta;
		
		if(defense < 0) {
			defense = 0;
		}
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void levelUp() {
		++level;
		
		experience = 0;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void modifyExperience(int delta) {
		experience += delta;
		
		if(experience < 0) {
			experience = 0;
		}
		
		if(experience == 100) {
			levelUp();
		}
	}
	
	public void modifySpeed(int delta) {
		currentSpeed += delta;
		
		if(currentSpeed < 0) {
			currentSpeed = 0;
		}
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}
	
	public void setDirection(Direction direction) {
		facingDirection = direction;
	}

	public Direction getDirection() {
		return facingDirection;
	}
}
