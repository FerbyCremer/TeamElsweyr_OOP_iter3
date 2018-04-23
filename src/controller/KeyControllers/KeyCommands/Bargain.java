package controller.KeyControllers.KeyCommands;

import model.Entities.Player;
import model.Items.Takeable.Tool;

public class Bargain extends KeyCommand {
    private Player player;
    private Tool tool;

    public Bargain(Player player){
        super("bargain");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
