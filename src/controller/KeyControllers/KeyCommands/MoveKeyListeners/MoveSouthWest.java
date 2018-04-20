package controller.KeyControllers.KeyCommands.MoveKeyListeners;

import controller.KeyControllers.KeyCommands.KeyCommand;
import model.Entities.Player;
import model.Map.Direction;

public class MoveSouthWest implements KeyCommand {
    private Player player;
    private Direction direction = Direction.SW;
    public MoveSouthWest(Player player){
        this.player = player;
    }
    @Override
    public void perform() {
        player.setFacingDirection(direction);
    }
}