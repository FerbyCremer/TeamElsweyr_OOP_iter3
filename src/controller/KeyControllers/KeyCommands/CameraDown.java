package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class CameraDown extends KeyCommand {
    private Player player;
    public CameraDown(Player player){
        super("cameraDown");
        this.player = player;
    }

    @Override
    public void perform() {
        player.attack();
    }
}
