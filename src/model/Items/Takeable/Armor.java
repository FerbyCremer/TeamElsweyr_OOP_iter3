package model.Items.Takeable;

import model.Entities.Entity;
import model.Inventory.Equipment;

public class Armor extends Takeable {
    private int defense;

    public Armor(int defense) {
        this.defense = defense;
    }

    @Override
    public void equip(Equipment equipment) {

    }

    @Override
    public void touchedBy(Entity entity) {

    }
}