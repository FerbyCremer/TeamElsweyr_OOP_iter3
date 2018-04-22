package model.Items.Takeable;


import model.Inventory.Equipment;
import model.Inventory.Inventory;
import model.Items.Item;

public abstract class Takeable extends Item {
    private boolean equipped;
    protected int price;
    private void addToInventory(Inventory inventory) {
    }

    public abstract void equip(Equipment equipment);

    public void delete() {
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquip(boolean equipped) {
    	this.equipped = equipped;
    }

    public int getPrice(){
        return price;
    }
}