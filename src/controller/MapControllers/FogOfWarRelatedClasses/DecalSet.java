package controller.MapControllers.FogOfWarRelatedClasses;

import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.ArrayList;

public interface DecalSet {

    //Probably need to pass in Player Point
    void update(ArrayList<Tile> tiles, Zone currentZone, Tile playerTile, String direction);
}
