package controller.LoadGame;

import java.util.ArrayList;
import java.util.List;

import model.Items.Item;
import model.Items.Takeable.Takeable;

public class ItemBuilder {
	public Item buildItem(List<String> attributes) {
		boolean equipped;
		
		switch(attributes.get(0)) {
		case "takeable":
			if(attributes.get(1).equalsIgnoreCase("true")) {
				equipped = true;
			}
			else equipped = false;
			
			Takeable item;
			
			switch(attributes.get(2)) {
			case "armor":
				item = buildArmor(attributes);
				break;
				
			case "ring":
				item = buildRing(attributes);
				break;
			
			case "consumable":
				item = buildConsumable(attributes);
				break;
				
			case "Tool":
				item = buildTool(attributes);
				break;
			}
			
			item.setEquip(equipped);
			
			return item;
			break;
			
		case "oneShot":
			EffectBuilder eBuilder = new EffectBuilder();
			List<String> effectAttributes = new ArrayList<String>();
			
			effectAttributes.add(attributes.get(3));
			effectAttributes.add(attributes.get(4));
			effectAttributes.add(attributes.get(5));
			
			EntityEffect effect = eBuilder.buildEffect(effectAttributes);
			
			
			break;
			
		case "interactive":
			break;
		}
	}
}
