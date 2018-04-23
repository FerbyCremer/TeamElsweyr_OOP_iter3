package controller.KeyControllers.KeyCommands;

import model.Entities.Player;
import view.ZoneView;

public class CameraLeft extends KeyCommand {

    private ZoneView zoneView;
    public CameraLeft(ZoneView zoneView){
        super("cameraLeft");
        this.zoneView = zoneView;
    }

    @Override
    public void perform() {
        zoneView.offSetCamera(-35,0);
    }
}
