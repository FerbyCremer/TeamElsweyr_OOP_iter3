package controller.MapControllers.FogOfWarRelatedClasses;

import model.Entities.Player;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.util.*;

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
        Tile centerTile = currentZone.getTileForEntity(player);
        ArrayList<Tile> tiles = new ArrayList<Tile>();

       /* //TODO: This violates SRP fix when ActionTypes are reusable for not action related events or there is a further abstraction
        for(int i = 0; i < visibleRadius; i++){
            int tileNum = tiles.size();
            for(int j = 0; j < tileNum; j++){
                for(int k = 0; k < 360; k += 60) {
                    Tile temp = tiles.get(j).getNeighbor(Direction.getDirectionClosest(k));
                    if(temp != null && !tiles.contains(temp))
                        tiles.add(temp);
                }
            }
        }*/

        Tile currentTile = currentZone.getTileForEntity(player);
        Direction direction = player.getDirection();
        Set<Tile> affectedTiles = new HashSet<Tile>();
        Utility utility = new Utility();
        for(int i = 1; i <= visibleRadius; i++) {
            utility.copyFromList(affectedTiles, generateCircle(currentTile, direction, i));
            currentTile = currentTile.getNeighbor(direction);
        }

        ArrayList<Tile> returnArray = new ArrayList<>(affectedTiles);
        return returnArray;
    }

    private ArrayList<Tile> generateCircle(Tile centerTile, Direction tempDirection, int currentRadius){
        ArrayList<Tile> tiles = new ArrayList<Tile>();

        tempDirection=tempDirection.getClockwise(120);
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < currentRadius; j++){
                tiles.add(centerTile);
                centerTile = centerTile.getNeighbor(tempDirection);
            }
            tempDirection = tempDirection.getClockwise(60);
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

    private static class Utility<T>{
        private void copyFromList(Set<T> copyTo, List<T> copyFrom){

            for (T element: copyFrom) {
                copyTo.add(element);
            }

        }
    }
}


