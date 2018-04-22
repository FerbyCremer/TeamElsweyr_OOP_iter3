package controller.KeyControllers.KeyCommands.MoveKeyListeners;

import controller.KeyControllers.KeyCommands.KeyCommand;
import model.Entities.Player;
import model.Map.Direction;

public class MoveSouth extends KeyCommand {
    private Player player;
    private Direction direction = Direction.S;
    public MoveSouth(Player player){
        super("MoveSouth");
        this.player = player;
    }
    @Override
    public void perform() {
        player.move(direction);
    }
}
