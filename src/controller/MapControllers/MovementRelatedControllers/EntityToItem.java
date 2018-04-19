package controller.MapControllers.MovementRelatedControllers;

import model.Entities.Entity;
import model.Items.Item;
import model.Map.Zone.ContentMap;
import model.Map.Zone.Zone;

public class EntityToItem implements CollisionChecker{
    private ContentMap<Entity> entityMap;
    private ContentMap<Item> itemMap;

    public EntityToItem(Zone zone){
        entityMap = zone.getEntityMap();
        itemMap = zone.getItemMap();
    }


    @Override
    public void checkCollision() {

    }
}
