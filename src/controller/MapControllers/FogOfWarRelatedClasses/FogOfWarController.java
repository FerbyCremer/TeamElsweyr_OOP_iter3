package controller.MapControllers.FogOfWarRelatedClasses;

import model.Entities.Player;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.ArrayList;

public class FogOfWarController {
    private Player player;
    private Zone currentZone;
    private DecalSet decalSet;
    private int visibleRadius;

    public FogOfWarController(Player player, Zone zone, DecalSet decalSet){
        this.player = player;
        currentZone = zone;
        this.decalSet = decalSet;
        visibleRadius = 4;
    }

    public void update(){
        ArrayList<Tile> tiles = calculateTilesInPlayersVisibleRadius();
        updateDecalSet(tiles, currentZone, currentZone.getTileForEntity(player));
    }

    private ArrayList<Tile> calculateTilesInPlayersVisibleRadius(){
       // Tile centerTile = currentZone.getTileForEntity(player);
        ArrayList<Tile> tiles = new ArrayList<Tile>();
        //TODO: This violates SRP fix when ActionTypes are reusable for not action related events or there is a further abstraction
        for(int i = 0; i < visibleRadius; i++){
            int tileNum = tiles.size();
            for(int j = 0; j < tileNum; j++){
                for(int k = 0; k < 360; k += 60) {
                    Tile temp = tiles.get(j).getNeighbor(Direction.getDirectionClosest(k));
                    if(!tiles.contains(temp))
                        tiles.add(temp);
                }
            }
        }

        return tiles;
    }

    private void updateDecalSet(ArrayList<Tile> tiles, Zone currentZone, Tile playerTile){
        String temp = getPlayerDirection();
        decalSet.update(tiles, currentZone, playerTile, temp);
    }

    public void updateZone(Zone currentZone){
        this.currentZone = currentZone;
    }

    private String getPlayerDirection(){
        return player.getDirection().name();
    }
}
