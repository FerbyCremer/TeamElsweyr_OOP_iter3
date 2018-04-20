package model.Inventory;

import java.util.ArrayList;

import model.Entities.EntityStats;
import model.Items.Item;
import model.Items.Takeable.Takeable;

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
		size = 10;
		wealth = 0;
		equipment = new Equipment(stats);
		items = new ArrayList<Takeable>();
	}
	
	public void equipItem(int index) {
		//equipment.equip(items.get(index));
	}
	
	public void addItem(Takeable item) {
		if(items.size() >= size) {
			System.out.println("Inventory is full, cannot pick up new item!");
			return;
		}
		
		items.add(item);
	}

}
