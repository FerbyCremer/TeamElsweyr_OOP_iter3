package model.Inventory;

import java.util.ArrayList;
import java.util.List;

import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;
import model.Entities.EntityStats;
import model.Entities.Player;
import model.Items.Item;
import model.Items.Takeable.Takeable;
import model.Items.Takeable.Tool;
import model.Updateable;

public class Inventory implements Saveable{
	private int wealth;
	private List<Takeable> items;
	private final int size = 30;
	private Equipment equipment;
	private List<Updateable> observers;
	private Takeable stolenItem;
	
	public Inventory(EntityStats stats) {
		wealth = 0;
		equipment = new Equipment(stats, new ArrayList<>());
		items = new ArrayList<>();
		stolenItem = null;
	}
	
	public Inventory(EntityStats stats, int wealth, List<Takeable> items) {
        this.items = items;
        List<Takeable> equipped = new ArrayList<>();
        for(Takeable item : items){
            if (item.isEquipped()){
                equipped.add(item);
            }
        }

        this.equipment = new Equipment(stats, equipped);
		this.wealth = wealth;

		stolenItem = null;

		//TODO parse items and equip equipped


		//TODO observers
        observers = new ArrayList<>();
	}

	
	public void equipItem(int index) {
		items.get(index).equip(equipment);
		exectue();
	}

	public void unequipItem(int index) {
		items.get(index).unequip(equipment);
		exectue();
	}
	
	public void addItem(Takeable item) {
		if(items.size() >= size) {
			System.out.println("Inventory is full, cannot pick up new item!");
			return;
		}
		
		items.add(item);
		exectue();
	}

	public void removeItem(int item) {
		if(items.size() >= size) {
			System.out.println("Inventory is full, cannot pick up new item!");
			return;
		}

		items.remove(item);
		exectue();
	}
	
	public void modifyWealth(int amount) {
		if(wealth + amount < 0) {
			System.out.println("You do not have enough money!");
			return;
		}
		
		wealth += amount;
		exectue();
	}
	
	//tells the equipment to use the currently equipped consumable
	public void useConsumable(Player player) {
		equipment.useConsumable(player);
	}
	
	//Tells the equipment to use the tool equipped
	public void useTool(Player player) {
		equipment.useTool(player);
	}

	public void add(Updateable updateable){
		observers.add(updateable);
	}

	private void exectue(){
		for(Updateable updateable : observers){
			updateable.update();
		}
	}

	public int getWealth(){
		return wealth;

	}

	@Override
	public String accept(SaveVisitor saveVisitor) {
		return saveVisitor.saveInventory(this);
	}

	public List<String> getItemNames(){
		//return items;
		List<String> itemNames = new ArrayList<String>();
		for(Takeable item :items)
			itemNames.add(item.getName());
		return itemNames;
	}

	public void removeItem(Item item){
		items.remove(item);
	}

	public List<Takeable> getItems() {
		return items;
	}

	public void setStolen(){
		int rand = (int)(Math.random() * (items.size() - 1));

		stolenItem = items.get(rand);
	}

	public Takeable giveStolen(){
		return stolenItem;
	}
}
