package controller.MapControllers.MovementRelatedControllers;

import controller.Handlers.AreaEffectHandler;
import model.Entities.Entity;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.AreaEffect;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.Set;

public class EntityToAreaEffect implements CollisionChecker {
    private ContentMap<Entity> entityMap;
    private ContentMap<AreaEffect> areaEffectMap;
    private AreaEffectHandler areaEffectHandler;

    public EntityToAreaEffect(Zone zone){
        entityMap = zone.getEntityMap();
        areaEffectMap = zone.getAreaEffectMap();
        areaEffectHandler = new AreaEffectHandler();
    }


    @Override
    public void checkCollision() {

        Set<Tile> entityTiles = entityMap.getTilesContentIsOn();
        Set<Tile> areaEffectTiles = areaEffectMap.getTilesContentIsOn();
        for (Tile entityTile : entityTiles){
            for (Tile areaEffectTile : areaEffectTiles){
                if (entityTile == areaEffectTile){
                    areaEffectHandler.handleCollision(entityMap.getContentAtTile(entityTile), areaEffectMap.getContentAtTile(areaEffectTile));
                }
            }
        }
    }
}
