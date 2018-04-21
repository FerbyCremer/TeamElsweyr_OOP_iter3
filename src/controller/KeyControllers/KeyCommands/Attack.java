package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class Attack extends KeyCommand {
    private Player player;
    public Attack(Player player){
        super("attack");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack(0);
    }
}
