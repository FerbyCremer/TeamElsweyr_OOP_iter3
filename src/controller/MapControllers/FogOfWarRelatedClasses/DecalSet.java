package controller.MapControllers.FogOfWarRelatedClasses;

import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.ArrayList;

public interface DecalSet {

    void update(ArrayList<Tile> tiles, Zone currentZone);
}
