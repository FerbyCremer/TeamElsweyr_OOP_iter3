package controller.KeyControllers.KeyCommands;

import controller.KeyControllers.KeyController;
import model.Entities.Player;
import view.ZoneView;

public class CameraDown extends KeyCommand {


    private ZoneView zoneView;

    public CameraDown(ZoneView zoneView){
        super("cameraDown");
        this.zoneView = zoneView;
    }

    @Override
    public void perform() {
        zoneView.offSetCamera(0,35);
    }
}
