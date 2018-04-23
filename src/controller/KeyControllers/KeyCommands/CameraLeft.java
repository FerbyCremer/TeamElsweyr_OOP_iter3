package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class CameraLeft extends KeyCommand {
    private Player player;
    public CameraLeft(Player player){
        super("cameraLeft");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
