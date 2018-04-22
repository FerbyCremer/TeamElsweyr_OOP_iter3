package controller.KeyControllers.KeyCommands;

import controller.KeyControllers.KeyControlState;

public class ToPlayer extends KeyCommand {
    private String name;
    private KeyControlState keyControlState;

    public ToPlayer(String name, KeyControlState keyControlState){
        super(name);
        keyControlState = keyControlState;
    }

    @Override
    public void perform() {
        keyControlState.swapToPlayer();
    }
}
