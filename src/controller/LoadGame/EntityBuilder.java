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

public class EntityBuilder {
	private BringOutYourDeadHandler handler;
	private EntityStats stats;
	private int index;
	
	public EntityBuilder(BringOutYourDeadHandler handler, EntityStats stats) {
		this.handler = handler;
		this.stats = stats;
	}
	
	public Player buildPlayer(List<String> attributes, KeyController controller) {
		index = 0;
		List<Integer> skillLvl = new ArrayList<Integer>();
		Player player = null;
		
		for(int i = index+1; i < attributes.size(); i++) {
			skillLvl.add(Integer.parseInt(attributes.get(i)));
		}
		
		switch(attributes.get(index++)) {
			case "summoner":
				player = Player.playerMakeSummoner(stats, skillLvl, controller, handler);
				break;
			case "smasher":
				player = Player.playerMakeSmasher(stats, skillLvl, controller, handler);
				break;
			case "sneak":
				player = Player.playerMakeSneak(stats, skillLvl, controller, handler);
				break;
		}
		
		return player;
	}
	
	public NPC buildNPC(List<String> attributes, AIController aiController) {
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
		
		return new NPC(stats, handler, aiController, state);
	}
	
	public Pet buildPet(AIController aiController) {
		return new Pet(stats, handler, aiController);
	}
	
	public Mount buildMount() {
		return new Mount(stats, handler);
	}

}
