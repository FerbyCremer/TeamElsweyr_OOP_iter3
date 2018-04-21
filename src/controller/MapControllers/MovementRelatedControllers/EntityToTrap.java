package controller.MapControllers.MovementRelatedControllers;

import controller.Handlers.TrapHandler;
import model.Entities.Entity;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.TileRelatedClasses.Trap;
import model.Map.Zone.Zone;

import java.util.Set;

public class EntityToTrap implements CollisionChecker {
    private ContentMap<Entity> entityMap;
    private ContentMap<Trap> trapMap;
    private TrapHandler trapHandler;

    public EntityToTrap(Zone zone){
        entityMap = zone.getEntityMap();
        trapMap = zone.getTrapMap();
        trapHandler = new TrapHandler();
    }


    @Override
    public void checkCollision() {

        Set<Tile> entityTiles = entityMap.getTilesContentIsOn();
        Set<Tile> trapTiles = trapMap.getTilesContentIsOn();
        for (Tile entityTile : entityTiles){
            for (Tile trapTile : trapTiles){
                if (entityTile == trapTile){
                    trapHandler.handleCollision(entityMap.getContentAtTile(entityTile), trapMap.getContentAtTile(trapTile));
                }
            }
        }
    }
}
