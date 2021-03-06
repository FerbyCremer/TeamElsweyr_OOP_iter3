package controller.KeyControllers.KeyCommands.MoveKeyListeners;

import controller.KeyControllers.KeyCommands.KeyCommand;
import model.Entities.Player;
import model.Map.Direction;

public class MoveNorthWest extends KeyCommand {
    private Player player;
    private Direction direction = Direction.NW;
    public MoveNorthWest(Player player){
        super("MoveNorthWest");
        this.player = player;
    }
    @Override
    public void perform() {
        player.move(direction);
    }
}
