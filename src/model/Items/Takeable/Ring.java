package model.Items.Takeable;

import controller.LoadGame.SaveVisitor;
import model.Entities.Entity;
import model.Inventory.Equipment;

public class Ring extends Takeable{
    private int health;

    public Ring(int health) {
        this.health = health;
    }

    @Override
    public void equip(Equipment equipment) {
    	equipment.equipRing(this);
    }

    @Override
    public void touchedBy(Entity entity) {
        entity.addToInventory(this);

    }

    public int getHealth(){
        return health;
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveRing(this);
    }
}
