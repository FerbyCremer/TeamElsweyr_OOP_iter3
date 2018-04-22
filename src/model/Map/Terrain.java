package model.Map;


import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;

import java.util.ArrayList;

public class Terrain implements Saveable{

    private String name;

    public Terrain(String name) {
        this.name = name;
    }

    public boolean canPass(ArrayList<Terrain> terrains){
        for (int i = 0; i < terrains.size(); i++) {
            if(this.equals(terrains.get(i))){
                return true;
            }
        }
        return false;
    }

    public boolean equals(Terrain terrain){

        if(this.name == terrain.name){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveTerrain(this);
    }
}
