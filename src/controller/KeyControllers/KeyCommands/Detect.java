package controller.KeyControllers.KeyCommands;

import controller.Handlers.ActionHandler;
import model.Actions.ActionType.Linear;
import model.Actions.TrapAction;
import model.Effect.TrapEffects.DetectEffect;
import model.Effect.TrapEffects.RemoveEffect;
import model.Entities.Player;
import model.Entities.Skill;
import model.Items.Takeable.Tool;

public class Detect extends KeyCommand {
    private Player player;
    private Tool tool;

    public Detect(Player player, ActionHandler actionHandler){
        super("detect");
        this.player = player;
        tool = new Tool(new Skill("detect"), actionHandler, new TrapAction(1, 80, new Linear(), new DetectEffect()), 12);
    }

    @Override
    public void perform() {
        tool.use(player);
    }
}
