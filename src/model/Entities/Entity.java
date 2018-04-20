package model.Entities;

import model.*;
import model.Inventory.Equipment;
import model.Inventory.Inventory;
import model.Map.Direction;
import model.Map.Terrain;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements EntityVisitable, EntityVisitor  {
		protected EntityStats stats;
		private Inventory inventory;
		private Equipment equipment;
		private ArrayList<Terrain> terrains;
		private ArrayList<Updateable> observers;
		private String name;
		
		public Entity() {
			stats = new EntityStats();
			inventory = new Inventory();
			equipment = new Equipment();
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
		}
		
		// Changes the entity's inventory, mainly for load game
		public void setInventory(Inventory inventory) {
			this.inventory = inventory;
		}
		
		//updateHealth is a wrapper method that tells EntityStats to modify the entity's health
		public void updateHealth(int healthChange) {
			stats.modifyHealth(healthChange);
		}

		
		//updateSpeed tells the EntityStats class to modify the entiy's speed
		public void updateCurrentSpeed(int speed) {
			stats.modifyCurrentSpeed(speed);
		}
		
		//getCurrentSpeed returns the entity's speed
		public int getCurrentSpeed() {
			return stats.getCurrentSpeed();
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
}
}

