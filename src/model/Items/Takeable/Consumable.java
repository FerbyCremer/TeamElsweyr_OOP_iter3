package model.Items.Takeable;

import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Entity;
import model.Entities.Player;
import model.Inventory.Equipment;

public class Consumable extends Takeable implements Usable{
    private EntityEffect effect;

    public Consumable(EntityEffect effect) {
        this.effect = effect;
    }

    @Override
    public void equip(Equipment equipment) {
    	equipment.equipConsumable(this);
    }

    @Override
    public void touchedBy(Entity entity) {

    }

    @Override
    public void use(Player player) {
    	effect.apply(player);
    }
}
