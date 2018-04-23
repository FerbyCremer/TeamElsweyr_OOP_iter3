package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class RemoveTrap extends KeyCommand {
    private Player player;
    public RemoveTrap(Player player){
        super("removeTrap");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
