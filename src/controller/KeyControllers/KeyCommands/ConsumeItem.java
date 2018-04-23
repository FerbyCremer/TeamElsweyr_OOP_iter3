package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class ConsumeItem extends KeyCommand {
    private Player player;

    public ConsumeItem(Player player) {
        super("consumeItem");
        this.player = player;
    }

    @Override
    public void perform() {
        player.consumeItem();
    }
}
