package controller.Handlers;

import model.Actions.Action;
import model.Actions.EntityAction;
import model.Actions.TrapAction;
import model.Entities.Entity;
import model.Entities.Player;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.TileRelatedClasses.Trap;
import model.Map.Zone.Zone;

import java.util.HashMap;

public class ActionPerformer {
    ContentMap<Entity> entityContentMap;
    ContentMap<Trap> trapContentMap;


    public ActionPerformer(Zone zone){
        entityContentMap = zone.getEntityMap();
        trapContentMap = zone.getTrapMap();
    }

    public void performAction(Entity entity, EntityAction entityAction){
        HashMap<Tile, Integer> tiles = entityAction.getAffectedTiles(entityContentMap.getTileOf(entity), entity.getDirection());
        for(Tile tile : tiles.keySet()){
            //This prob doesn't work.
            Entity entityHit = entityContentMap.getContentAtTile(tile);
            if(entityHit!= null){
                entityAction.apply(entityHit, tiles.get(tile));
            }
        }
    }

    public void performAction(Entity entity, TrapAction trapAction){
        HashMap<Tile, Integer> tiles = trapAction.getAffectedTiles(entityContentMap.getTileOf(entity), entity.getDirection());
        for(Tile tile : tiles.keySet()){
            //This prob doesn't work.
            Trap trapHit = trapContentMap.getContentAtTile(tile);
            if(trapHit!= null){
                trapAction.apply(trapHit, tiles.get(tile));
            }
        }
    }
}
