package controller.Handlers;

import model.Actions.Action;
import model.Actions.ActionType.ActionInterface;
import model.Actions.ActionType.ActionObserver;
import model.Actions.EntityAction;
import model.Actions.TrapAction;
import model.Entities.Entity;
import model.Entities.Player;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.TileRelatedClasses.Trap;
import model.Map.Zone.Zone;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ActionPerformer {
    ContentMap<Entity> entityContentMap;
    ContentMap<Trap> trapContentMap;
    ActionInterface actionInterface;


    public ActionPerformer(Zone zone){
        entityContentMap = zone.getEntityMap();
        trapContentMap = zone.getTrapMap();
    }

    public void performAction(Player player, EntityAction entityAction){
        HashMap<Tile, Integer> tiles = entityAction.getAffectedTiles(player.getDirection());
        ArrayList<Point> points = new ArrayList<>();
        String name = null;
        for(Tile tile : tiles.keySet()){
            //This prob doesn't work.
            points.add(tile.getCoordinate());
            name = entityAction.getEffectName();
            Entity entityHit = entityContentMap.getContentAtTile(tile);
            if(entityHit!= null){
                entityAction.apply(entityHit, tiles.get(tile));
            }
        }

        actionInterface.update(points, name);
    }

    public void performAction(Player player, TrapAction trapAction){
        HashMap<Tile, Integer> tiles = trapAction.getAffectedTiles(player.getDirection());
        ArrayList<Point> points = new ArrayList<>();
        String name = null;
        for(Tile tile : tiles.keySet()){
            //This prob doesn't work.
            points.add(tile.getCoordinate());
            name = trapAction.getEffectName();
            Trap trapHit = trapContentMap.getContentAtTile(tile);
            if(trapHit!= null){
                trapAction.apply(trapHit, tiles.get(tile));
            }
        }

        actionInterface.update(points, name);
    }
}
