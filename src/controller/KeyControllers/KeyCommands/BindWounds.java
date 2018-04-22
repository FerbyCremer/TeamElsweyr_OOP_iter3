package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class BindWounds extends KeyCommand {
    private Player player;
    public BindWounds(Player player){
        super("bindWounds");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}