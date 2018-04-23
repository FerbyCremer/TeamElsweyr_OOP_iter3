package model.Items.Takeable;


import controller.Handlers.ActionHandler;
import model.Actions.Action;
import model.Entities.Entity;
import model.Entities.Player;
import model.Entities.Skill;
import model.Inventory.Equipment;

public class Tool extends Takeable implements Usable {
    private Skill skill;
    private ActionHandler actionHandler;
    private Action action;
    private int cooldown;

    public Tool(Skill skill, ActionHandler actionHandler, Action action, int cooldown) {
        this.skill = skill;
        this.actionHandler = actionHandler;
        this.action = action;
        this.cooldown = cooldown;
    }

    @Override
    public void equip(Equipment equipment) {
        equipment.equipTool(this);
    }

    @Override
    public void unequip(Equipment equipment) {
        equipment.unequipTool();
    }

    @Override
    public void touchedBy(Entity entity) {
        entity.addToInventory(this);

    }

    public void use(Player player){
        actionHandler.createAction(player, action.clone(skill.getModifier()));
    }

}
