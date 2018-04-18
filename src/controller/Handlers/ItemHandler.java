package controller.Handlers;

import model.Entities.Entity;
import model.Items.Item;
import model.Map.Zone.ContentMap;

public class ItemHandler {
    private ContentMap<Item> itemMap;
    private Entity entity;

    public ItemHandler(ContentMap<Item> itemMap, Entity entity) {
        this.itemMap = itemMap;
        this.entity = entity;
    }

    private void handleCollision(Item item){}
}
