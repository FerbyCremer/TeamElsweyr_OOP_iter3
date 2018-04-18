package model.Map;

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
        for(Zone z: zones){
            if(zoneID == z.getID())
                return z;
        }

        return null;
    }
}
