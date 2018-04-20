package controller.KeyControllers.KeyCommands.MoveKeyListeners;

import controller.KeyControllers.KeyCommands.KeyCommand;
import controller.KeyControllers.KeyControlState;

public class ToCamera implements KeyCommand {
    private String name;
    private KeyControlState keyControlState;

    public ToCamera(String name, KeyControlState keyControlState){
        this.name = name;
        this.keyControlState = keyControlState;
    }

    @Override
    public void perform() {
        keyControlState.swapToCamera();
    }
}
