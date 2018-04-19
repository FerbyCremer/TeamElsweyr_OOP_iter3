package model.Entities;

import model.*;
import model.Inventory.Equipment;
import model.Inventory.Inventory;
import model.Map.Direction;
import model.Map.Terrain;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
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
			if(direction == stats.getDirection()) {
				stats.modifySpeed(stats.getMaxSpeed());
			}
			
			else {
				stats.setDirection(direction);
			}
		}
		
		//updateHealth is a wrapper method that tells EntityStats to modify the entity's health
		public void updateHeath(int healthChange) {
			stats.modifyHealth(healthChange);
		}

    public String getName() {
        return name;
    }
}