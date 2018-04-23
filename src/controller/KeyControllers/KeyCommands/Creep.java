package controller.KeyControllers.KeyCommands;

import controller.KeyControllers.KeyController;
import model.Entities.Player;

public class Creep extends KeyCommand {

    private Player player;
    private KeyController keyController;

    public Creep(Player player, KeyController keyController){
        super("creep");
        this.player = player;
        this.keyController = keyController;
    }

    @Override
    public void perform() {
        keyController.removeKeyListener("creep");
        keyController.addKeyListener(new BackStab(player, keyController));
        player.setDetectRange(0);
    }
}
