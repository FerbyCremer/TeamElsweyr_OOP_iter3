package controller.KeyControllers;

import java.util.HashMap;

public class KeyControlState {

    private HashMap<String, KeyController> controllers;
    private KeyController activeContoller;
    //private KeyBindingController keyBindingController;


    private void swapController(KeyController keyController){
        activeContoller = keyController;
    }

    public void changeKeycode(String prevKey, String newKey){
        activeContoller.changeKeyCode(prevKey, newKey);
    }

	private HashMap<String, KeyController> controllers;
	private KeyController activeController;
	//private KeyBindingController keyBindings;
	
	public KeyControlState() {
		activeController = controllers.get("player");
	}

	private void SwapControllerTo(KeyController controller) {
		activeController = controller;
	}
	
	public void swapToCamera() {
		SwapControllerTo(controllers.get("camera"));
	}
	
	public void swapToInventory() {
		SwapControllerTo(controllers.get("inventory"));
	}
	
	public void swapToPlayer() {
		SwapControllerTo(controllers.get("player"));
	}
	


}
