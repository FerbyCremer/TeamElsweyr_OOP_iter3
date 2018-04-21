package controller.MapControllers.MovementRelatedControllers;

import model.Entities.Entity;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.River;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.HashMap;

public class MovementController {
    private ContentMap<Entity> entityMap;
    private ContentMap<River> riverMap;
    private HashMap<Entity, EntityMover> entityMovers;

    public MovementController(Zone zone){
        entityMap = zone.getEntityMap();
        riverMap = zone.getRiverMap();
    }

    public void updateEntitys(){
        for (Tile entityTile : entityMap.getTilesContentIsOn()) {
            Entity currentEntity = entityMap.getContentAtTile(entityTile);

        }

    }


}
