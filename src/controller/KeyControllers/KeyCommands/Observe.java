package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class Observe extends KeyCommand {
    private Player player;
    public Observe(Player player){
        super("observe");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
