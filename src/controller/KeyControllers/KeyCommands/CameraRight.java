package controller.KeyControllers.KeyCommands;

import model.Entities.Player;
import view.ZoneView;

public class CameraRight extends KeyCommand {

    private ZoneView zoneView;
    public CameraRight(ZoneView zoneView){
        super("cameraRight");
        this.zoneView = zoneView;
    }

    @Override
    public void perform() {
        zoneView.offSetCamera(35,0);
    }
}
