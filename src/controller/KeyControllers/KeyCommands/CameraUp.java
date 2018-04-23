package controller.KeyControllers.KeyCommands;

import model.Entities.Player;
import view.ZoneView;

public class CameraUp extends KeyCommand {

    private ZoneView zoneView;
    public CameraUp(ZoneView zoneView){
        super("cameraUp");
        this.zoneView = zoneView;
    }

    @Override
    public void perform() {
        zoneView.offSetCamera(0,-35);
    }
}
