package controller.KeyControllers;

import controller.ViewControllers.KeyBindingController;

import java.util.HashMap;

public class KeyControlState {

    private HashMap<String, KeyController> controllers;
    private KeyController activeController;
    private KeyBindingController keyBindings;

    //private KeyBindingController keyBindingController;
	public KeyControlState() {
		//this.activeController = controllers.get("player");
	}

	public void addKeyController (KeyController controller){

		controllers.put(controller.getName(), controller);
		keyBindings.loadKeyCodes(controller.keyListeners);
	}

	private void SwapControllerTo(KeyController controller) {
		//TODO: call this function right after all initializing to set activeController to the playerController
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
