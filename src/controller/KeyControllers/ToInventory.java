package controller.KeyControllers;

import controller.KeyControllers.KeyCommands.KeyCommand;

public class ToInventory extends KeyCommand {
  // private String name;
    private KeyControlState keyControlState;

    public ToInventory(String name, KeyControlState keyControlState){
        super(name);
        this.keyControlState = keyControlState;

    }

    @Override
    public void perform() {
        keyControlState.swapToInventory();
    }
}
