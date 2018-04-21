package controller.KeyControllers.KeyCommands.MoveKeyListeners;

import controller.KeyControllers.KeyCommands.KeyCommand;
import controller.KeyControllers.KeyControlState;

public class ToCamera extends KeyCommand {
    private KeyControlState keyControlState;

    public ToCamera(String name, KeyControlState keyControlState){
        super(name);
        this.keyControlState = keyControlState;
    }

    @Override
    public void perform() {
        keyControlState.swapToCamera();
    }
}
