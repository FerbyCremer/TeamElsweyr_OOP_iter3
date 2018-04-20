package controller.KeyControllers.KeyCommands;

import model.Entities.Player;
import model.Map.Direction;

public class MoveNorth implements KeyCommand {
    private Player player;
    private Direction direction = Direction.N;
    public MoveNorth(Player player){
        this.player = player;
    }
    @Override
    public void perform() {
        player.setFacingDirection(direction);
    }
}
