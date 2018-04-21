package controller.LoadGame;

import java.util.ArrayList;
import java.util.List;

import model.Actions.Action;
import model.Actions.EntityAction;
import model.Actions.TrapAction;
import model.Actions.ActionType.ActionType;
import model.Actions.ActionType.Angular;
import model.Actions.ActionType.Linear;
import model.Actions.ActionType.Radial;
import model.Effect.EntityEffect.EntityEffect;
import model.Effect.TrapEffects.TrapEffect;

public class ActionBuilder {
	private int index;
	private EffectBuilder eBuilder;
	
	public ActionBuilder(EffectBuilder eBuilder) {
		this.eBuilder = eBuilder;
	}

	public Action buildAction(List<String> attributes) {
		Action action = null;
		index = 0;
		int maxRange;
		int accuracy;
		ActionType type;
		EntityEffect entityEffect;
		TrapEffect trapEffect;
		List<String> temp;
		
		
		switch(attributes.get(index++)){
			case "entity":
				maxRange = Integer.parseInt(attributes.get(index++));
				accuracy = Integer.parseInt(attributes.get(index++));
				type = getType(attributes.get(index++));
				
				temp = new ArrayList<String>();
				for(int i = ++index; i < attributes.size(); i++ ) {
					temp.add(attributes.get(i));
				}
				
				entityEffect = eBuilder.buildEntityEffect(temp);
				
				action = new EntityAction(maxRange, accuracy, type, entityEffect);
				break;
				
			case "trap":
				maxRange = Integer.parseInt(attributes.get(index++));
				accuracy = Integer.parseInt(attributes.get(index++));
				type = getType(attributes.get(index++));
				
				temp = new ArrayList<String>();
				for(int i = ++index; i < attributes.size(); i++ ) {
					temp.add(attributes.get(i));
				}
				
				trapEffect = eBuilder.buildTrapEffect(temp);
				
				action = new TrapAction(maxRange, accuracy, type, trapEffect);
				
				break;
		}
		
		return action;
	}
	
	private ActionType getType(String type) {
		ActionType temp = null;
		
		switch(type) {
			case "linear":
				temp = new Linear();
				break;
				
			case "Angular":
				temp = new Angular();
				break;
			case "Radial":
				temp = new Radial();
				break;
		}
		
		return temp;
	}
}
