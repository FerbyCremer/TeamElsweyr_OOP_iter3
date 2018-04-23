package controller.KeyControllers.KeyCommands;

import controller.KeyControllers.KeyBindingMapper;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Entities.Player;

public abstract class KeyCommand implements EventHandler<KeyEvent> {

    protected String name;
    protected KeyCode keyCode;

    public KeyCommand(String name){
        this.name = name;
    }

    public void setKeyCode(KeyBindingMapper keyBindingMapper){
        keyCode = keyBindingMapper.getKeyCodeFor(name);
        System.out.println("Binding Keycode: " + keyCode + " to " + name);
    }

    public void setKeyCode(KeyCode keyCode){
        this.keyCode = keyCode;
    }

    public KeyCode getKeyCode() {
        return keyCode;
    }

    /*    public void setKeyCode(KeyCode keyCode) {
        this.keyCode = keyCode;
    }*/

    public String getName() {
        return name;
    }

    public abstract void perform();

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == keyCode){
            perform();
        }
    }
}
