package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class Creep extends KeyCommand {
    private Player player;
    public Creep(Player player){
        super("creep");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
