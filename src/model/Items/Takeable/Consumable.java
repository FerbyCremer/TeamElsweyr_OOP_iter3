package model.Items.Takeable;

import controller.LoadGame.SaveVisitor;
import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Entity;
import model.Entities.Player;
import model.Inventory.Equipment;

public class Consumable extends Takeable implements Usable{
    private EntityEffect effect;

    public EntityEffect getEffect() {
        return effect;
    }

    public Consumable(EntityEffect effect) {
        this.effect = effect;
    }

    @Override
    public void equip(Equipment equipment) {
    	equipment.equipConsumable(this);
    }

    @Override
    public void touchedBy(Entity entity) {
        entity.addToInventory(this);
    }

    @Override
    public void use(Player player) {
    	effect.apply(player);
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveConsumable(this);
    }
}
