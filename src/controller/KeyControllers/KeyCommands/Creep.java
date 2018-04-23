package controller.KeyControllers.KeyCommands;

import controller.Handlers.ActionHandler;
import controller.KeyControllers.KeyController;
import model.Entities.Player;

public class Creep extends KeyCommand {

    private Player player;
    private KeyController keyController;
    private ActionHandler actionHandler;

    public Creep(Player player, KeyController keyController, ActionHandler actionHandler){
        super("creep");
        this.player = player;
        this.keyController = keyController;
        this.actionHandler = actionHandler;
    }

    @Override
    public void perform() {
        keyController.removeKeyListener("creep");
        keyController.addKeyListener(new BackStab(player, keyController, actionHandler));
        player.setDetectRange(0);
    }
}
