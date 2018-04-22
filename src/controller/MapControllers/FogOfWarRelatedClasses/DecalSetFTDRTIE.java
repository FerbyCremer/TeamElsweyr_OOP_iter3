package controller.MapControllers.FogOfWarRelatedClasses;

import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DecalSetFTDRTIE implements DecalSet {
    private Point playerPos;
    private String direction;
    private HashMap<Point, ArrayList<String>> zoneMap;
    private int xDim;
    private int yDim;
    private String ghostName;


    /*
    FTDRTIE
    FOG
    TERRAIN
    DECAL
    RIVER
    TRAP
    ITEM
    ENTITY
     */

    public DecalSetFTDRTIE(){ }

    public DecalSetFTDRTIE(int xDim, int yDim) {
        this.xDim = xDim;
        this.yDim = yDim;
        this.direction = "N";
        zoneMap = new HashMap<Point, ArrayList<String>>();
        for(int i = 0; i < xDim; i++){
            for(int j = 0; j < yDim; j++){
                Point p = new Point(i, j);
                ArrayList<String> temp = new ArrayList<String>();
                temp.add("fog");
                zoneMap.put(p, temp);
            }
        }
    }

    @Override
    public void update(ArrayList<Tile> tiles, Zone currentZone, Tile playerTile, String direction) {
        updatePlayerPos(playerTile);
        updatePlayerDirection(direction);
        createZoneMap(tiles, currentZone);
    }

    private void updatePlayerDirection(String direction) {
        this.direction = direction;
    }

    private void updatePlayerPos(Tile playerTile) {
        playerPos = makeNewPoint(playerTile.getCoordinate());
    }

    private void addGhostImageToSceneTiles(){
        Set<Point> points = zoneMap.keySet();
        for(Point point: points){
            if(!zoneMap.get(point).contains(ghostName)){
                zoneMap.get(point).add(ghostName);
            }
        }
    }

    private void createZoneMap(ArrayList<Tile> tiles, Zone currentZone){
        addGhostImageToSceneTiles();

        for(Tile t: tiles){
            Point p = makeNewPoint(t.getCoordinate());
            ArrayList<String> names = zoneMap.get(p);
            names.clear();
            addTerrainName(t, names);
            addDecalName(t, currentZone, names);
//            addRiverName(t, currentZone, names);
            addTrapName(t, currentZone, names);
            addItemName(t, currentZone, names);
            addEntityName(t, currentZone, names);
            zoneMap.put(p, names);
        }
    }

    private void addTerrainName(Tile tile, ArrayList<String> name){
        name.add(tile.getTerrainName());
    }

    private void addDecalName(Tile tile, Zone currentZone, ArrayList<String> names){
        String decal = currentZone.getDecalName(tile);
        if(decal != null)
            names.add(decal);
    }

//    private void addRiverName(Tile t, Zone currentZone, ArrayList<String> names) {
//        String river = currentZone.getRiverName(t);
//        if(river != null)
//            names.add(river);
//
//    }
//
    //Trap will be responsible for having it's get name correspond to its active and visible
    private void addTrapName(Tile t, Zone currentZone, ArrayList<String> names) {
        String trap = currentZone.getTrapName(t);
        if(trap != null)
            names.add(trap);

    }

    private void addItemName(Tile t, Zone currentZone, ArrayList<String> names) {
        String item = currentZone.getItemName(t);
        if(item != null)
            names.add(item);
    }

    private void addEntityName(Tile t, Zone currentZone, ArrayList<String> names) {
        String entity = currentZone.getEntityName(t);
        if(entity != null)
            names.add(entity);
    }

    private Point makeNewPoint(Point point){
        Point p = new Point(point.x, point.y);
        return p;
    }

    public int getXDim(){
        return xDim;
    }
    
    public int getYDim(){
        return yDim;
    }

    public ArrayList<String> getTileContents(Point point){
        System.out.println("   asfsaf   " +zoneMap.get(point));
        return zoneMap.get(point);
    }
}
