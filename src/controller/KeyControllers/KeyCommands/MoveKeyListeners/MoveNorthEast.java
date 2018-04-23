package controller.KeyControllers.KeyCommands.MoveKeyListeners;

import controller.KeyControllers.KeyCommands.KeyCommand;
import model.Entities.Player;
import model.Map.Direction;

public class MoveNorthEast extends KeyCommand {
    private Player player;
    private Direction direction = Direction.NE;
    public MoveNorthEast(Player player){
        super("moveNorthEast");
        this.player = player;
    }
    @Override
    public void perform() {
        player.move(direction);
    }
}
