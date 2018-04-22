package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class ConsumeItem extends KeyCommand {
    private Player player;

    public ConsumeItem() {
        super("consume");
    }

    public ConsumeItem(Player player) {
        super("consume");
    }

    @Override
    public void perform() {
        player.consumeItem();
    }
}
