package controller.MapControllers.MovementRelatedControllers;

import model.Entities.Entity;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.AreaEffect;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.Set;

public class EntityToAreaEffect implements CollisionChecker {
    private ContentMap<Entity> entityMap;
    private ContentMap<AreaEffect> areaEffectMap;

    public EntityToAreaEffect(Zone zone){
        entityMap = zone.getEntityMap();
        areaEffectMap = zone.getAreaEffectMap();
    }


    //Get the key
    @Override
    public void checkCollision() {
        Set<Tile> areaEffectTiles = areaEffectMap.getTilesContentIsOn();
    }
}
