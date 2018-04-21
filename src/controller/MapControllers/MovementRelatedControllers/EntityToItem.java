package controller.MapControllers.MovementRelatedControllers;

import controller.Handlers.ItemHandler;
import model.Entities.Entity;
import model.Items.Item;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.Set;

public class EntityToItem implements CollisionChecker{
    private ContentMap<Entity> entityMap;
    private ContentMap<Item> itemMap;
    private ItemHandler itemHandler;

    public EntityToItem(Zone zone){
        entityMap = zone.getEntityMap();
        itemMap = zone.getItemMap();
        itemHandler = new ItemHandler();
    }


    @Override
    public void checkCollision() {

        Set<Tile> entityTiles = entityMap.getTilesContentIsOn();
        Set<Tile> itemTiles = itemMap.getTilesContentIsOn();
        for (Tile entityTile : entityTiles){
            for (Tile itemTile : itemTiles){
                if (entityTile == itemTile){
                    itemHandler.handleCollision(entityMap.getContentAtTile(entityTile), itemMap.getContentAtTile(itemTile));
                    itemMap.removeContent(itemTile);
                }
            }
        }
    }
}
