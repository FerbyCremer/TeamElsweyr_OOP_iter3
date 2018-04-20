package controller.Handlers;

import model.Entities.Entity;
import model.Items.Item;
import model.Map.Zone.ContentMap;

public class ItemHandler {

    public ItemHandler() { }

    public void handleCollision(Entity entity, Item item){
        item.touchedBy(entity);
    }
}
