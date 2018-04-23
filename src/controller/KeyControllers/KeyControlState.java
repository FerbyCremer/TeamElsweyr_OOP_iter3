package controller.KeyControllers;

import controller.KeyControllers.KeyCommands.KeyCommand;
import javafx.scene.Scene;

import java.awt.event.KeyEvent;
import java.beans.EventHandler;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class KeyControlState {

	private Scene scene;
    private ConcurrentHashMap<String, KeyController> controllers;
    private KeyController activeController;

    //private KeyBindingController keyBindingController;
	public KeyControlState(Scene scene, KeyController playerController, KeyController cameraCommands) {
		this.scene = scene;
		controllers = new ConcurrentHashMap<>();
		addKeyController(playerController);
		addKeyController(cameraCommands);
		activeController = controllers.get("player");
		scene.setOnKeyPressed(activeController);
	}

	public void addKeyController (KeyController controller){
		controllers.put(controller.getName(), controller);
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
