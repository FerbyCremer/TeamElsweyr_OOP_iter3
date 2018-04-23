package controller.KeyControllers;

import controller.KeyControllers.KeyCommands.KeyCommand;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KeyController implements EventHandler<KeyEvent> {

    private String name;
    public List<KeyCommand> keyListeners;
    private KeyBindingMapper keyBindingMapper;

    public KeyController(String name, KeyBindingMapper keyBindingMapper){
        this.name = name;
        this.keyBindingMapper = keyBindingMapper;
        keyListeners = new ArrayList<>();
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
        //keyCommand.setKeyCode(newCode);

    }

    public void addKeyListener(KeyCommand key){
        key.setKeyCode(keyBindingMapper);
        keyListeners.add(key);
        //TODO: communicate with keyBindingController to load key codes for specific keyListener
    }

    public void removeKeyListener(String name) {
        for (int i = 0; i < keyListeners.size(); i++) {
            if (keyListeners.get(i).getName().equals(name)) {
                keyListeners.remove(keyListeners.get(i));
            }
        }
    }

    @Override
    public void handle(KeyEvent event) {
        for (int i = 0; i < keyListeners.size(); i++) {
            keyListeners.get(i).handle(event);
        }
    }
}
