package controller.KeyControllers;

import controller.KeyControllers.KeyCommands.KeyCommand;

import java.util.HashMap;

public class KeyController {
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

}
