package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class Attack implements KeyCommand {
    private Player player;
    public Attack(Player player){
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack(0);
    }
}
