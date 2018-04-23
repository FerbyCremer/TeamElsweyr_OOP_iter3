package controller.KeyControllers.KeyCommands;

import controller.Handlers.ActionHandler;
import controller.KeyControllers.KeyController;
import model.Actions.ActionType.Linear;
import model.Actions.EntityAction;
import model.Effect.EntityEffect.DamageEffect;
import model.Entities.Player;
import model.Entities.Skill;
import model.Items.Takeable.Tool;

public class BackStab extends KeyCommand {

    private Player player;
    private KeyController keyController;
    Tool tool;
    private int oldDetectRange;
    ActionHandler actionHandler;

    public BackStab(Player player, KeyController keyController, ActionHandler actionHandler){
        super("backStab");
        this.player = player;
        this.keyController = keyController;
        this.oldDetectRange = this.player.getDetectRange();
        this.actionHandler = actionHandler;
        tool = new Tool(new Skill("backStab"), this.actionHandler, new EntityAction(1, 80, new Linear(), new DamageEffect(50)), 12);
    }

    @Override
    public void perform() {
        keyController.removeKeyListener("backStab");
        keyController.addKeyListener(new Creep(player, keyController, actionHandler));
        player.setDetectRange(oldDetectRange);
        tool.use(player);
    }
}
