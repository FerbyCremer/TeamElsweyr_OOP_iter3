package controller.KeyControllers.KeyCommands.MoveKeyListeners;

import controller.KeyControllers.KeyCommands.KeyCommand;
import model.Entities.Player;
import model.Map.Direction;

public class MoveSouthEast extends KeyCommand {
    private Player player;
    private Direction direction = Direction.SE;
    public MoveSouthEast(Player player){
        super("moveSouthEast");
        this.player = player;
    }
    @Override
    public void perform() {
        player.move(direction);
    }
}
