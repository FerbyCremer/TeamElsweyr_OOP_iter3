package controller.KeyControllers;

import java.util.HashMap;

public class KeyControlState {
    private HashMap<String, KeyController> controllers;
    private KeyController activeContoller;
    //private KeyBindingController keyBindingController;

    public KeyControlState(){}
    private void swapController(KeyController keyController){
        activeContoller = keyController;
    }

    public void swapToCamera(){
        //activeContoller
    }

    public void swapToInventory(){}

    public void swapToPlayer(){}

    public void changeKeycode(String prevKey, String newKey){
        activeContoller.changeKeyCode(prevKey, newKey);
    }
}
