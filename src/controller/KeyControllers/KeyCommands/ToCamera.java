package controller.KeyControllers.KeyCommands;

import controller.KeyControllers.KeyController;
import model.Entities.Player;
import view.ZoneView;

public class ToCamera extends KeyCommand {
    private KeyController keyController;
    private ZoneView zoneView;

    public ToCamera(KeyController keyController, ZoneView zoneView){
        super("toCamera");
        this.keyController = keyController;
        this.zoneView = zoneView;
    }

    @Override
    public void perform() {
        zoneView.setCameraLocked(false);
        keyController.addKeyListener(new CameraDown(zoneView));
        keyController.addKeyListener(new CameraRight(zoneView));
        keyController.addKeyListener(new CameraUp(zoneView));
        keyController.addKeyListener(new CameraLeft(zoneView));
        keyController.addKeyListener(new ToPlayer(keyController, zoneView));
        keyController.removeKeyListener("toCamera");
    }
}
