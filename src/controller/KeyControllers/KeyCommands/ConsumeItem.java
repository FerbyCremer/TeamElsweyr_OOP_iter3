package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class ConsumeItem extends KeyCommand {
    private Player player;

    public ConsumeItem() {
        super("consumeItem");
    }

    public ConsumeItem(Player player) {
        super("consumeItem");
    }

    @Override
    public void perform() {
        player.consumeItem();
    }
}
