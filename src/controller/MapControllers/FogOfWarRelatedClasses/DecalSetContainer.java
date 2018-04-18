package controller.MapControllers.FogOfWarRelatedClasses;

import java.util.HashMap;

public class DecalSetContainer {
    private HashMap<String, DecalSet> decalSetContainer;

    public DecalSetContainer(HashMap<String, DecalSet> decalSetContainer) {
        this.decalSetContainer = decalSetContainer;
    }

    public DecalSet getDecalSet(String zoneID){
        return decalSetContainer.get(zoneID);
    }
}
