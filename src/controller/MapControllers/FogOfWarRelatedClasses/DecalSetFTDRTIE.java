package controller.MapControllers.FogOfWarRelatedClasses;

import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DecalSetFTDRTIE implements DecalSet {
    private Point playerPos;
    private HashMap<Point, ArrayList<String>> zoneMap;

    public DecalSetFTDRTIE() {
    }

    @Override
    public void update(ArrayList<Tile> tiles, Zone currentZone) {
        createZoneMap();
    }

    private void createZoneMap(){}
}
