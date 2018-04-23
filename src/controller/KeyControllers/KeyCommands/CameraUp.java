package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class CameraUp extends KeyCommand {
    private Player player;
    public CameraUp(Player player){
        super("cameraUp");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
