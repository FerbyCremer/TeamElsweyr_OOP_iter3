package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class Detect extends KeyCommand {
    private Player player;
    public Detect(Player player){
        super("detect");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
