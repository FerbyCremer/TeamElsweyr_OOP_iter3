package controller.KeyControllers.KeyCommands;

import controller.Handlers.ActionHandler;
import model.Actions.ActionType.Linear;
import model.Actions.EntityAction;
import model.Effect.EntityEffect.HealEffect;
import model.Entities.Player;
import model.Entities.Skill;
import model.Items.Takeable.Tool;

public class BindWounds extends KeyCommand {
    private Player player;
    private Tool tool;

    public BindWounds(Player player, ActionHandler actionHandler){
        super("bindWounds");
        this.player = player;
        tool = new Tool(new Skill("bindWounds"), actionHandler, new EntityAction(0, 80, new Linear(), new HealEffect(12)), 12);
    }

    @Override
    public void perform() {
        tool.use(player);
    }
}