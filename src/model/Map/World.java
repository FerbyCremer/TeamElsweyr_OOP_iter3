package model.Map;

import model.Entities.Entity;
import model.Entities.Player;
import model.Map.Zone.Zone;

import java.util.ArrayList;

public class World {
    private ArrayList<Zone> zones;
    private Zone currentZone;

    public World(ArrayList<Zone> zones, Zone zone){
        this.zones = zones;
        currentZone = zone;
    }

    public Zone changeZone(String zoneID){
        currentZone = getZone(zoneID);

        return currentZone;
    }

    private Zone getZone(String zoneID){
        for(Zone z: zones){
            if(zoneID == z.getID()) {
                return z;
            }
        }

        return null;
    }


    public void removeEntityFromZone(Entity entity){
        currentZone.removeEntityFromMap(entity);
    }

    public void addEntityToZone(Player player, String zoneID) {
        Zone zone = getZone(zoneID);
        zone.addEntityToMap(player);
    }
}
