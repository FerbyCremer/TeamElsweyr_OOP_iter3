package model.Items.Takeable;

import model.Entities.Entity;
import model.Inventory.Equipment;

public class Ring extends Takeable{
    private int health;

    public Ring(int health) {
        this.health = health;
    }

    @Override
    public void equip(Equipment equipment) {

    }

    @Override
    public void touchedBy(Entity entity) {

    }

    public int getHealth(){
        return health;
    }
}
