package model.Inventory;

import java.util.ArrayList;
import java.util.List;

import model.Entities.EntityStats;
import model.Entities.Player;
import model.Items.Takeable.*;


public class Equipment {
	private StatsChanger statChanger;
	private Armor armorSlot;
	private Ring ringSlot;
	private Consumable consumableSlot;
	private Tool toolSlot;
	private List<Tool> toolList;
	
	//TODO loading equip methods
	public Equipment(EntityStats stats, List<Takeable> equipped) {
		statChanger = new StatsChanger(new EntityStats());
		for(Takeable item : equipped){
			item.equip(this);
		}
		statChanger = new StatsChanger(stats);
	}
	
	public void equipArmor(Armor armor) {
		if (armorSlot != null){
			unequipArmor();
		}
		armorSlot = armor;
		armor.setEquip(true);
		statChanger.notifyDefense(armor.getDefense());
	}
	
	public void unequipArmor() {
		armorSlot.setEquip(false);
		statChanger.notifyDefense(-armorSlot.getDefense());
		armorSlot = null;
	}
	
	public void equipRing(Ring ring) {
		if (ringSlot != null){
			unequipRing();
		}
		ringSlot = ring;
		ringSlot.setEquip(true);
		statChanger.notifyHealth(ring.getHealth());
	}
	
	public void unequipRing() {
		ringSlot.setEquip(false);
		statChanger.notifyHealth(-ringSlot.getHealth());
		ringSlot = null;
	}
	
	public void equipConsumable(Consumable potion) {
		if(consumableSlot != null){
			unequipConsumable();
		}
		consumableSlot = potion;
	}
	
	public void unequipConsumable() {
		consumableSlot.setEquip(false);
		consumableSlot = null;
	}
	
	public void equipTool(Tool tool) {
		if (toolSlot != null){
			unequipTool();
		}
		tool.setEquip(true);
		toolSlot = tool;
	}
	
	public void unequipTool() {
		toolSlot.setEquip(false);
		toolSlot = null;
	}
	
	//Tells the tool to create an action
	public void useTool(Player player) {
		if (toolSlot!=null){
			toolSlot.use(player);
		}
	}
	
	//Tells the consumable to apply its effect to the player
	public void useConsumable(Player player) {
		if (consumableSlot != null){
			consumableSlot.use(player);
		}
	}
}
