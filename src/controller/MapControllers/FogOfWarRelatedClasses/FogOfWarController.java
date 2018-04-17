package controller.MapControllers.FogOfWarRelatedClasses;

import model.Entities.Player;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.ArrayList;

public class FogOfWarController {
    private Player player;
    private Zone currentZone;
    private DecalSet decalSet;

    public FogOfWarController(Player player, Zone zone, DecalSet decalSet){
        this.player = player;
        currentZone = zone;
        this.decalSet = decalSet;
    }

    public void update(){}

    private ArrayList<Tile> calculateTilesInPlayersVisibleRadius(){
        return null;
    }

    private void updateDecalSet(){}

    public void updateZone(Zone currentZone){
        this.currentZone = currentZone;
    }
}
