package model.Inventory;

import model.Entities.EntityStats;

public class StatsChanger {
	private EntityStats stats;
	
	public StatsChanger(EntityStats stats) {
		this.stats = stats;
	}
	
	public void notifyDefense(int amount) {
		stats.modifyDefense(amount);
	}
	
	public void notifyHealth(int amount) {
		stats.modifyMaxHealth(amount);
	}

}
