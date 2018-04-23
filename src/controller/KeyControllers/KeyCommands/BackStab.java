package controller.KeyControllers.KeyCommands;

import controller.KeyControllers.KeyController;
import model.Entities.Player;

public class BackStab extends KeyCommand {

    private Player player;
    private KeyController keyController;
    private int oldDetectRange;

    public BackStab(Player player, KeyController keyController){
        super("backStab");
        this.player = player;
        this.keyController = keyController;
        this.oldDetectRange = this.player.getDetectRange();
    }

    @Override
    public void perform() {
        keyController.removeKeyListener("backStab");
        keyController.addKeyListener(new Creep(player, keyController));
        player.setDetectRange(oldDetectRange);
    }
}
