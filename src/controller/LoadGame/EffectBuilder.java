package controller.LoadGame;

import java.util.List;

import controller.MapControllers.WorldController;
import model.Effect.EntityEffect.*;
import model.Effect.TrapEffects.DetectEffect;
import model.Effect.TrapEffects.RemoveEffect;
import model.Effect.TrapEffects.TrapEffect;

public class EffectBuilder {
	private WorldController wController;
	private int index;
	
	public EffectBuilder(WorldController controller) {
		this.wController = controller;
	}
	
	public EntityEffect buildEntityEffect(List<String> attributes) {
		index = 0;
		EntityEffect effect = null;
		int amount;

		switch(attributes.get(index++)) {
			case "damageEffect":
				amount = Integer.parseInt(attributes.get(index++));
				effect = new DamageEffect(amount);
				break;
			
			case "healEffect":
				amount = Integer.parseInt(attributes.get(index++));
				effect = new HealEffect(amount);
				break;
			
			case "expEffect":
				amount = Integer.parseInt(attributes.get(index++));
				effect = new ExpEffect(amount);
				break; 
			
			case "observeEffect":
				amount = Integer.parseInt(attributes.get(index++));
				effect = new ObserveEffect(amount);
				break; 
			
			case "bargainEffect":
				amount = Integer.parseInt(attributes.get(index++));
				effect = new BargainEffect(amount);
				break; 
			
			case "teleportEffect":
				String zoneID = attributes.get(index++);
				effect = new TeleportEffect(wController, zoneID);
				break;

			case "directionEffect":
				amount = Integer.parseInt(attributes.get(index++));
				effect = new DirectionEffect(amount);
				break;
		}
		
		return effect;
	}
	
	public TrapEffect buildTrapEffect(List<String> attributes) {
		TrapEffect effect = null;
		index = 0;
		
		switch(attributes.get(index++)) {
			case "removeEffect":
				effect = new RemoveEffect();
				break;
			case "detectEffect":
				effect = new DetectEffect();
				break;
		}
		
		return effect;
	}
}
