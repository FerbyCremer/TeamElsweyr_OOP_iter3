package controller.KeyControllers.KeyCommands;

import controller.KeyControllers.KeyControlState;
import controller.KeyControllers.KeyController;
import view.ZoneView;

public class ToPlayer extends KeyCommand {

    private KeyController keyController;
    private ZoneView zoneView;

    public ToPlayer(KeyController keyController, ZoneView zoneView){
        super("toPlayer");
        this.keyController = keyController;
        this.zoneView = zoneView;
    }

    @Override
    public void perform() {
        zoneView.setCameraLocked(true);
        keyController.removeKeyListener("cameraUp");
        keyController.removeKeyListener("cameraDown");
        keyController.removeKeyListener("cameraLeft");
        keyController.removeKeyListener("cameraRight");
        keyController.addKeyListener(new ToCamera(keyController, zoneView));
        keyController.removeKeyListener("toPlayer");
    }
}
