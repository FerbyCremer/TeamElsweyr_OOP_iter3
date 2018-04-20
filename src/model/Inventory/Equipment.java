package model.Inventory;

import java.util.ArrayList;

import model.Entities.EntityStats;
import model.Entities.Player;
import model.Items.Takeable.*;


public class Equipment {
	private StatsChanger statChanger;
	private Armor armorSlot;
	private Ring ringSlot;
	private Consumable consumableSlot;
	private ArrayList<Tool> toolList;
	private ArrayList<Tool> invisibleTools;
	
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
	
	public void equipConsumable(Consumable potion) {
		consumableSlot = potion;
	}
	
	public void unequipConsumable() {
		consumableSlot = null;
	}
	
	public void equipTool(Tool tool) {
		toolList.add(tool);
	}
	
	public void unequipTool(int index) {
		toolList.remove(index);
	}
	
	//Tells the tool to create an action
	public void useTool(int index, Player player) {
		toolList.get(index).use(player);
	}
	
	//Tells the consumable to apply its effect to the player
	public void useConsumable(Player player) {
		consumableSlot.use(player);
	}

	public void addInvisibleTool(Tool tool) {
		invisibleTools.add(tool);
	}
}
