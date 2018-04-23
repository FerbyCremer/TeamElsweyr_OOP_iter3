package controller.KeyControllers.KeyCommands;

import controller.Handlers.ActionHandler;
import model.Actions.ActionType.Linear;
import model.Actions.EntityAction;
import model.Effect.EntityEffect.ObserveEffect;
import model.Entities.Player;
import model.Entities.Skill;
import model.Items.Takeable.Tool;

public class Observe extends KeyCommand {
    private Player player;
    private Tool tool;

    public Observe(Player player, ActionHandler actionHandler){
        super("observe");
        this.player = player;
        tool = new Tool(new Skill("observe"), actionHandler, new EntityAction(0, 80, new Linear(), new ObserveEffect()), 20);
    }

    @Override
    public void perform() {
        tool.use(player);
    }
}
