package controller.KeyControllers;

import controller.KeyControllers.KeyCommands.KeyCommand;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.util.HashMap;
import java.util.List;

public class KeyController implements EventHandler<KeyEvent> {

    private String name;
    public List<KeyCommand> keyListeners;

    public KeyController(String name, List<KeyCommand> keys){
        this.name = name;
        keyListeners = keys;
    }

    public String getName() {
        return name;
    }

    public void register(List<KeyCommand> keys){
        keyListeners = keys;
    }

    public void changeKeyCode(KeyCommand prevCode, KeyCode newCode){
        int temp = keyListeners.indexOf(prevCode);
        KeyCommand keyCommand = keyListeners.get(temp);
        keyCommand.setKeyCode(newCode);
    }

    public void setKeyListeners(List<KeyCommand> keyListeners) {
        this.keyListeners = keyListeners;
        //TODO: communicate with keyBindingController to load key codes for each keyListener
    }

    public void addKeyListener(KeyCommand key){
        keyListeners.add(key);
        //TODO: communicate with keyBindingController to load key codes for specific keyListener
    }

    public void removeKeyListener(String name){
        keyListeners.remove(name);
    }

    @Override
    public void handle(KeyEvent event) {
        for (KeyCommand keyListener : keyListeners) {
            keyListener.handle(event);
        }
    }
}
