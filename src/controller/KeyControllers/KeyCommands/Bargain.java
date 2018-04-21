package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class Bargain extends KeyCommand {
    private Player player;
    public Bargain(Player player){
        super("bargain");
        this.player = player;
    }

    @Override
    public void perform() {
        player.useTool(0);
    }
}
