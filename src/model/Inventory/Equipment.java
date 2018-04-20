package model.Inventory;

import java.util.ArrayList;

import model.Entities.EntityStats;
import model.Items.Takeable.*;


public class Equipment {
	private StatsChanger statChanger;
	private Armor armorSlot;
	private Ring ringSlot;
	private Consumable potionSlot;
	private ArrayList<Tool> toolList;
	
	public Equipment(EntityStats stats) {
		toolList = new ArrayList<Tool>();
		statChanger = new StatsChanger(stats);
	}
	
	public void equipArmor(Armor armor) {
		armorSlot = armor;
		statChanger.notifyDefense(armor.getDefense());
	}
	
	public void unequipArmor() {
		armorSlot = null;
	}
	
	public void equipRing(Ring ring) {
		ringSlot = ring;
		statChanger.notifyHealth(ring.getHealth());
	}
	
	public void unequipRing() {
		ringSlot = null;
	}
	
	public void equipPotion(Consumable potion) {
		potionSlot = potion;
	}
	
	public void unequipPotion() {
		potionSlot = null;
	}
	
	public void equipTool(Tool tool) {
		toolList.add(tool);
	}
	
	public void unequipTool(int index) {
		toolList.remove(index);
	}
	
	public void useTool(int index) {
		//toolList.get(index).use(player);
	}
	
	public void useConsumable() {
		//potion.use();
	}

}
