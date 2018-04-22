package model.Map;

import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;
import model.Entities.Entity;
import model.Entities.Player;
import model.Map.Zone.Zone;

import java.util.ArrayList;
import java.util.List;

public class World implements Saveable{
    private List<Zone> zones;
    private Zone currentZone;

    public World(List<Zone> zones, Zone zone){
        this.zones = zones;
        currentZone = zone;
    }

    public Zone changeZone(String zoneID){

        currentZone = getZone(zoneID);

        System.out.println(zoneID);
        System.out.println("Zone to change to " + currentZone.getID());
        return currentZone;
    }

    public List<Zone> getZones(){return zones;}

    private Zone getZone(String zoneID){
        for(Zone z: zones){
            System.out.println("Zone: " + z.getID());
            if(zoneID.equals(z.getID())) {
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

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveWorld(this);
    }
}
