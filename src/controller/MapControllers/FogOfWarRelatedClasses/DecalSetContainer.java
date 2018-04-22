package controller.MapControllers.FogOfWarRelatedClasses;

import model.Map.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class DecalSetContainer {
    private ConcurrentHashMap<String, DecalSet> decalSetContainer;

    public DecalSetContainer(ConcurrentHashMap<String, DecalSet> decalSetContainer) {
        this.decalSetContainer = decalSetContainer;
    }

    public DecalSetContainer(World world){
        decalSetContainer = new ConcurrentHashMap<>();
        ArrayList<String> zoneIDs = world.getZoneIds();
        for(String zoneID : zoneIDs){
            decalSetContainer.put(zoneID, new DecalSetFTDRTIE(world.getZoneXDim(zoneID), world.getZoneYDim(zoneID)));
        }
    }

    public void addDecalSet(String zoneID){
        decalSetContainer.put(zoneID, new DecalSetFTDRTIE());
    }

    public DecalSet getDecalSet(String zoneID){
        return decalSetContainer.get(zoneID);
    }
}
