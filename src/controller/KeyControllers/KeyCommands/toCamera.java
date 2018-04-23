package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class toCamera extends KeyCommand {
    private Player player;
    public toCamera(Player player){
        super("toCamera");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
