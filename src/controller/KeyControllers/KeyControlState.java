package controller.KeyControllers;

import java.util.HashMap;

public class KeyControlState {
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
	
	//TODO change the name of the variables passed into the parameter
	public void changeKeyCode(int x, int y) {
		
	}
}
