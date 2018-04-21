package controller.KeyControllers.KeyCommands.MoveKeyListeners;

import controller.KeyControllers.KeyCommands.KeyCommand;
import model.Entities.Player;
import model.Map.Direction;

public class MoveNorth extends KeyCommand {
    private Player player;
    private Direction direction = Direction.N;

    public MoveNorth(Player player){
        super("MoveNorth");
        this.player = player;
    }
    @Override
    public void perform() {
        player.move(direction);
    }
}
