package controller.KeyControllers.KeyCommands;

import model.Entities.Player;
import model.Map.Direction;

public class MoveNorthWest implements KeyCommand{
    private Player player;
    private Direction direction = Direction.NW;
    public MoveNorthWest(Player player){
        this.player = player;
    }
    @Override
    public void perform() {
        player.setFacingDirection(direction);
    }
}
