package controller.LoadGame;

import java.util.ArrayList;
import java.util.List;

import controller.Handlers.ActionHandler;
import model.Actions.Action;
import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Skill;
import model.Items.Item;
import model.Items.OneShot.OneShot;
import model.Items.Takeable.Armor;
import model.Items.Takeable.Consumable;
import model.Items.Takeable.Ring;
import model.Items.Takeable.Takeable;
import model.Items.Takeable.Tool;

public class ItemBuilder {
	private ActionHandler handler;
	private int index;
	private EffectBuilder eBuilder;
	
	public ItemBuilder(ActionHandler handler, EffectBuilder eBuilder) {
		this.handler = handler;
		this.eBuilder = eBuilder;
	}
	
	
	public Item buildItem(List<String> attributes) {
		boolean equipped;
		index = 0;
		Item item = null;
		
		String name = attributes.get(index++);
		
		switch(attributes.get(index++)) {
			case "takeable":
				equipped = Boolean.parseBoolean(attributes.get(index++));

				switch(attributes.get(index++)) {
				    case "armor":
					    item = buildArmor(attributes);
					    break;
				
				    case "ring":
					    item = buildRing(attributes);
					    break;
			
				    case "consumable":
					    item = buildConsumable(attributes);
					    break;
				
				    case "tool":
					    item = buildTool(attributes);
					    break;
			    }
                ((Takeable) item).setEquip(equipped);

			break;
			
		case "oneshot":
			List<String> effectAttributes = new ArrayList<String>();
			
			
			effectAttributes.add(attributes.get(index++));
			effectAttributes.add(attributes.get(index++));
			
			EntityEffect effect = eBuilder.buildEntityEffect(effectAttributes);
			
			item = new OneShot(effect);
			
			break;
			
		case "interactive":
			break;
		}
		
		item.setName(name);
		
		return item;
	}
	
	private Takeable buildArmor(List<String> attributes) {
		Takeable item = new Armor(Integer.parseInt(attributes.get(index++)));
		
		return item;
	}
	
	private Takeable buildRing(List<String> attributes) {
		Takeable item = new Ring(Integer.parseInt(attributes.get(index++)));
		
		return item;
	}
	
	private Takeable buildConsumable(List<String> attributes) {
		Takeable item;
		
		List<String> effectAttributes = new ArrayList<String>();
		
		index++;
		effectAttributes.add(attributes.get(index++));
		effectAttributes.add(attributes.get(index++));
		
		EntityEffect entityEffect = eBuilder.buildEntityEffect(effectAttributes);
		item = new Consumable(entityEffect);
		
		return item;
	}
	
	private Takeable buildTool(List<String> attributes) {
		Takeable item;
		
		Skill skill = new Skill(attributes.get(index++));
		
		int cooldown = Integer.parseInt(attributes.get(index++));
		
		List<String> actionAttributes = new ArrayList<String>();
		
		for(int i = index; i < attributes.size()-1; i++) {
			actionAttributes.add(attributes.get(i));
		}
		
		ActionBuilder aBuilder = new ActionBuilder(eBuilder);
		
		Action action = aBuilder.buildAction(actionAttributes);
		System.out.println(action);
		
		item = new Tool(skill, handler, action, cooldown);
		
		return item;
	}
}