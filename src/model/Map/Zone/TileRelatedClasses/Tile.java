package model.Map.Zone.TileRelatedClasses;

import model.Entities.Entity;
import model.Map.Direction;
import model.Map.Terrain;

import java.awt.*;
import java.util.HashMap;
import java.util.Vector;

public class Tile {
    private Terrain terrain;
    private boolean obstacle;
    private HashMap<Direction, Tile> neighborhood;
    private Point coordinate;

    //TODO neighborhood is set in zone
    public Tile(Terrain terrain, boolean obstacle, Point coordinate) {
        this.terrain = terrain;
        this.obstacle = obstacle;
        //this.neighborhood = neighborhood;
        this.coordinate = coordinate;
    }

	public void setNeighbors(HashMap<Direction,Tile> tiles){
        this.neighborhood = tiles;
    }

    public boolean canMove(Entity entity){
        return terrain.canPass(entity.getTerrains()) && !obstacle;
    }

    public Tile getNeighbor(Direction direction) {
        return neighborhood.get(direction); //What does this return if there is no tile for that direction?
    }

    public HashMap<Direction, Tile> getNeighbors() {
        return neighborhood;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public String getTerrainName(){
        return terrain.getName();
    }

    public boolean isObstacle() {
        return obstacle;
    }
}
