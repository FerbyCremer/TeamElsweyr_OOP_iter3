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
        return currentZone;
    }

    public List<Zone> getZones(){return zones;}

    private Zone getZone(String zoneID){
        for(Zone z: zones){
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

    public ArrayList<String> getZoneIds(){
        ArrayList<String> zoneIds = new ArrayList<String>();
        for(Zone zone : zones){
            zoneIds.add(zone.getID());
        }
        return zoneIds;
    }

    public int getZoneXDim(String zoneID){
        Zone zone = getZone(zoneID);
        return zone.getXDim();
    }

    public int getZoneYDim(String zoneID){
        Zone zone = getZone(zoneID);
        return zone.getYDim();
    }
}
