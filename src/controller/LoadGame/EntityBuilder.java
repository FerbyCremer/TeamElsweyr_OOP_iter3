package controller.LoadGame;

import java.util.ArrayList;
import java.util.List;

import controller.EntityControllers.AIController;
import controller.Handlers.BringOutYourDeadHandler;
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

public class EntityBuilder {
	private BringOutYourDeadHandler handler;
	private int index;
	
	public EntityBuilder(BringOutYourDeadHandler handler) {
		this.handler = handler;
	}
	
	public Player buildPlayer(List<String> attributes, KeyController controller, Inventory inventory, List<Terrain> terrains, EntityStats stats) {
		index = 0;
		List<Integer> skillLvl = new ArrayList<Integer>();
		Player player = null;
		
		for(int i = index+1; i < attributes.size(); i++) {
			skillLvl.add(Integer.parseInt(attributes.get(i)));
		}

		String name = attributes.get(index++);

		switch(name) {
			case "summoner":
				player = Player.playerMakeSummoner(stats, skillLvl, controller, inventory, terrains, name, handler);
				break;
			case "smasher":
				player = Player.playerMakeSmasher(stats, skillLvl, controller, inventory, terrains, name, handler);
				break;
			case "sneak":
				player = Player.playerMakeSneak(stats, skillLvl, controller, inventory, terrains, name, handler);
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
				state = new ShopKeeperState();
				break;
				
			case "talkativeState":
				state = new TalkativeState();
				break;
		}
		
		return new NPC(stats, handler, aiController, inventory, terrains, "npc", state);
	}
	
	public Pet buildPet(AIController aiController, Inventory inventory, List<Terrain> terrains, EntityStats stats) {
		return new Pet(stats, handler, aiController, inventory, terrains, "pet");
	}
	
	public Mount buildMount(Inventory inventory, List<Terrain> terrains, EntityStats stats) {
		return new Mount(stats, handler, inventory, terrains, "mount");
	}

}
