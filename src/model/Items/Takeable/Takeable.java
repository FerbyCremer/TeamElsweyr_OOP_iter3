package model.Items.Takeable;


import javafx.beans.property.BooleanProperty;
import model.Inventory.Equipment;
import model.Inventory.Inventory;
import model.Items.Item;

public abstract class Takeable extends Item {
    private boolean equipped;
    private final BooleanProperty isEquipped = null;

    protected int price;
    private void addToInventory(Inventory inventory) {
    }

    public abstract void equip(Equipment equipment);

    public abstract void unequip(Equipment equipment);

    //TODO: Make this a deep copy
    public Takeable clone() {
        return this;
    }

    public void delete() {
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquip(boolean equipped) {
    	this.equipped = equipped;
    }

    public BooleanProperty isEquippedProperty(){
        isEquipped.setValue(equipped);
        return isEquipped;
    }

    public int getPrice(){
        return price;
    }
}