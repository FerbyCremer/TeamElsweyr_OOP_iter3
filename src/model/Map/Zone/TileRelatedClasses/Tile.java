package model.Map.Zone.TileRelatedClasses;

import model.Entities.Entity;
import model.Map.Terrain;

import java.awt.*;
import java.util.Vector;

public class Tile {
    private Terrain terrain;
    private boolean obstacle;
    private Vector<Tile> neighborhood;
    private Point coordinate;

    public Tile(Terrain terrain, boolean obstacle, Vector<Tile> neighborhood, Point coordinate) {
        this.terrain = terrain;
        this.obstacle = obstacle;
        this.neighborhood = neighborhood;
        this.coordinate = coordinate;
    }

    public void setNeighbors(Vector<Tile> tiles){
        this.neighborhood = tiles;
    }

    public boolean canMove(Entity entity){
       // if(terrain.canPass(entity.get))
        return false;
    }
    public Vector<Tile> getNeighbors() {
        return neighborhood;
    }
}
