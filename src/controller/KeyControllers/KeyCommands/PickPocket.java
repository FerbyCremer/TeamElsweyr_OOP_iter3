package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class PickPocket extends KeyCommand {
    private Player player;
    public PickPocket(Player player){
        super("pickPocket");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
