package controller.LoadGame;

import java.util.ArrayList;
import java.util.List;

import controller.EntityControllers.AIController;
import controller.Handlers.BringOutYourDeadHandler;
import controller.Handlers.MountHandler;
import controller.KeyControllers.KeyController;
import model.Entities.EntityStats;
import model.Entities.Mount;
import model.Entities.Pet;
import model.Entities.Player;
import model.Entities.NPC.AggroState;
import model.Entities.NPC.CalmState;
import model.Entities.NPC.NPC;
import model.Entities.NPC.NPCState;
import model.Entities.NPC.ShopKeeperState;
import model.Entities.NPC.TalkativeState;
import model.Inventory.Inventory;
import model.Map.Terrain;
import view.TradeView;

public class EntityBuilder {
	private BringOutYourDeadHandler deadHandler;
	private int index;
	
	public EntityBuilder(BringOutYourDeadHandler deadHandler) {
		this.deadHandler = deadHandler;
	}
	
	public Player buildPlayer(List<String> attributes, KeyController controller, Inventory inventory, String avatar, List<Terrain> terrains, MountHandler mountHandler, EntityStats stats) {
		index = 0;
		List<Integer> skillLvl = new ArrayList<Integer>();
		Player player = null;

		for(int i = index+1; i < attributes.size()-2; i++) {
			skillLvl.add(Integer.parseInt(attributes.get(i)));
		}

		String name = attributes.get(index++);

		switch(name) {
			case "summoner":
				player = Player.playerMakeSummoner(stats, skillLvl, controller, inventory, terrains, name, avatar, mountHandler, deadHandler);
				break;
			case "smasher":
				player = Player.playerMakeSmasher(stats, skillLvl, controller, inventory, terrains, name, avatar, mountHandler, deadHandler);
				break;
			case "sneak":
				player = Player.playerMakeSneak(stats, skillLvl, controller, inventory, terrains, name, avatar, mountHandler, deadHandler);
				break;
		}
		
		return player;
	}
	
	public NPC buildNPC(List<String> attributes, AIController aiController, Inventory inventory, List<Terrain> terrains, EntityStats stats) {
		NPCState state = null;
		
		switch(attributes.get(0)) {
			case "calm":
				state = new CalmState();
				break;
				
			case "aggro":
				state = new AggroState();
				break;
			
			case "shopKeeper":
				state = new ShopKeeperState(new TradeView());
				break;
				
			case "talkative":
				state = new TalkativeState();
				break;
		}
		
		return new NPC(stats, deadHandler, aiController, inventory, terrains, attributes.get(1), state);
	}
	
	public Pet buildPet(List<String> attributes, AIController aiController, Inventory inventory, List<Terrain> terrains, EntityStats stats) {
		return new Pet(stats, deadHandler, aiController, inventory, terrains, attributes.get(0));
	}
	
	public Mount buildMount(List<String> attributes, Inventory inventory, List<Terrain> terrains, EntityStats stats) {
		return new Mount(stats, deadHandler, inventory, terrains, attributes.get(0));
	}

}
