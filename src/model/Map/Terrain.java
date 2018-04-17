package model.Map;

import java.util.ArrayList;

public class Terrain {

    private String name;

    public Terrain(String name) {
        this.name = name;
    }

    public boolean canPass(ArrayList<Terrain> terrains){
        return false;
    }

    public boolean equals(Terrain terrain){
       return false;
    }
}
