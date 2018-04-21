package controller.KeyControllers;

import controller.KeyControllers.KeyCommands.KeyCommand;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


import java.util.HashMap;

public class KeyController implements EventHandler<KeyEvent> {

    private String name;
    private HashMap<String, KeyCommand> keyListeners;

    public KeyController(String name, HashMap<String, KeyCommand> keys){
        this.name = name;
        keyListeners = keys;
    }

    public void register(HashMap<String, KeyCommand> keys){
        keyListeners = keys;
    }

    public void changeKeyCode(String prevCode, String newCode){
        KeyCommand temp = keyListeners.get(prevCode);
        keyListeners.remove(prevCode);
        keyListeners.put(newCode, temp);
    }

    public void addKeyLister(String code, KeyCommand key){
        keyListeners.put(code, key);
    }

    public void removeKeyListener(String code){
        keyListeners.remove(code);
    }

    @Override
    public void handle(KeyEvent event) {
        String temp = event.getCode().toString().toLowerCase();
        if(keyListeners.containsKey(event))
            keyListeners.get(temp).perform();
    }
}
