package model.Inventory;

import java.util.ArrayList;

import model.Entities.EntityStats;
import model.Entities.Player;
import model.Items.Item;
import model.Items.Takeable.Takeable;
import model.Items.Takeable.Tool;

public class Inventory {
	private int wealth;
	private ArrayList<Takeable> items;
	private int size;
	private Equipment equipment;
	
	public Inventory(int size, EntityStats stats) {
		this.size = size;
		wealth = 0;
		equipment = new Equipment(stats);
		items = new ArrayList<Takeable>();
	}
	
	public Inventory(EntityStats stats) {
		size = 30;
		wealth = 0;
		equipment = new Equipment(stats);
		items = new ArrayList<Takeable>();
	}
	
	public void equipItem(int index) {
		items.get(index).equip(equipment);
	}
	
	public void addItem(Takeable item) {
		if(items.size() >= size) {
			System.out.println("Inventory is full, cannot pick up new item!");
			return;
		}
		
		items.add(item);
	}
	
	public void modifyWealth(int amount) {
		if(wealth + amount < 0) {
			System.out.println("You do not have enough money!");
			return;
		}
		
		wealth += amount;
	}
	
	//tells the equipment to use the currently equipped consumable
	public void useConsumable(Player player) {
		equipment.useConsumable(player);
	}
	
	//Tells the equipment to use the tool at the specified index
	public void useTool(int index, Player player) {
		equipment.useTool(index, player);
	}
	
	public void equipInvisibleTool(Tool tool) {
		equipment.addInvisibleTool(tool);
	}

	//method only for testing
	public Takeable getItem(int index){
		return items.get(index);
	}
}
