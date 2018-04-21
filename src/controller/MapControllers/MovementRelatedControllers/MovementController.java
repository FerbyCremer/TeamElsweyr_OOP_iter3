package controller.MapControllers.MovementRelatedControllers;

import model.Entities.Entity;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.River;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MovementController {
    private ContentMap<Entity> entityMap;
    private ContentMap<River> riverMap;
    private ConcurrentHashMap<Entity, EntityMover> entityMovers;

    public MovementController(Zone zone){
        entityMap = zone.getEntityMap();
        riverMap = zone.getRiverMap();
        buildEntityMovers();
    }

    private void buildEntityMovers(){
        entityMovers = new ConcurrentHashMap<>();
        for (Tile entityTile : entityMap.getTilesContentIsOn()){
            Entity entity = entityMap.getContentAtTile(entityTile);
            EntityMover newMover = new EntityMover(entity, entityMap);
            entityMovers.put(entity, newMover);
        }
    }

    public void updateEntitys(){
        for (Tile entityTile : entityMap.getTilesContentIsOn()) {

            Entity currentEntity = entityMap.getContentAtTile(entityTile);

            if (riverMap.hasTile(entityTile)){
                riverMap.getContentAtTile(entityTile).apply(currentEntity);
            }

            EntityMover entityMover = entityMovers.get(currentEntity);
            //Blame whoever didn't put obstacles on the map corners if null ptr exception
            Tile tileInDerivedDirection = entityTile.getNeighbor(currentEntity.getDirection());
            entityMover.changeLocation(tileInDerivedDirection);

            currentEntity.setCurrentSpeed(0);
        }
    }
}
