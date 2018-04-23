package controller.KeyControllers.KeyCommands.MoveKeyListeners;

import controller.KeyControllers.KeyCommands.KeyCommand;
import model.Entities.Player;
import model.Map.Direction;

public class MoveSouthWest extends KeyCommand {
    private Player player;
    private Direction direction = Direction.SW;
    public MoveSouthWest(Player player){
        super("moveSouthWest");
        this.player = player;
    }
    @Override
    public void perform() {
        player.move(direction);
    }
}
