package model.Items.Takeable;

import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Entity;
import model.Entities.Player;
import model.Inventory.Equipment;

public class Consumable extends Takeable implements Usable{
    private EntityEffect effect;
    public Consumable(EntityEffect effect) {
        this.effect = effect;
        price = 50;
    }

    @Override
    public void equip(Equipment equipment) {
    	equipment.equipConsumable(this);
    }

    @Override
    public void unequip(Equipment equipment) {
        equipment.unequipConsumable();
    }

    @Override
    public void touchedBy(Entity entity) {
        entity.addToInventory(this);
    }

    @Override
    public void use(Player player) {
    	effect.apply(player);
    }


}
