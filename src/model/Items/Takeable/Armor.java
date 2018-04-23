package model.Items.Takeable;

import model.Entities.Entity;
import model.Inventory.Equipment;

public class Armor extends Takeable {
    private int defense;
    private int price;
    public Armor(int defense) {
        this.defense = defense;
        price = 300;
    }

    @Override
    public void equip(Equipment equipment) {
    	equipment.equipArmor(this);
    }

    @Override
    public void unequip(Equipment equipment) {
        equipment.unequipArmor();
    }

    @Override
    public void touchedBy(Entity entity) {
        entity.addToInventory(this);
    }
    
    public int getDefense() {
    	return defense;
    }

}
