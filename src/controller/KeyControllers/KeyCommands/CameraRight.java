package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class CameraRight extends KeyCommand {
    private Player player;
    public CameraRight(Player player){
        super("cameraRight");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
