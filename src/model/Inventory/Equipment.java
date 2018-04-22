package model.Inventory;

import java.util.ArrayList;

import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;
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
	
	//TODO loading equip methods
	public Equipment(EntityStats stats) {
		toolList = new ArrayList<Tool>();
		statChanger = new StatsChanger(stats);
	}
	
	public void equipArmor(Armor armor) {
		unequipArmor();
		armorSlot = armor;
		statChanger.notifyDefense(armor.getDefense());
	}
	
	public void unequipArmor() {
		if(armorSlot != null){
			statChanger.notifyDefense(-1 * armorSlot.getDefense());
		}
		armorSlot = null;
	}
	
	public void equipRing(Ring ring) {
		unequipRing();
		ringSlot = ring;
		statChanger.notifyHealth(ring.getHealth());
	}
	
	public void unequipRing() {
		if(ringSlot != null){
			statChanger.notifyHealth(-1 * ringSlot.getHealth());
		}
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
