package controller.KeyControllers.KeyCommands;

import controller.KeyControllers.KeyControlState;

public class ToPlayer implements KeyCommand {
    private String name;
    private KeyControlState keyControlState;

    public ToPlayer(String name, KeyControlState keyControlState){
        this.name = name;
        keyControlState = keyControlState;
    }

    @Override
    public void perform() {
        keyControlState.swapToPlayer();
    }
}
