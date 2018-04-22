package model.Map;


import java.util.ArrayList;
import java.util.List;

public class Terrain {

    private String name;

    public Terrain(String name) {
        this.name = name;
    }

    public boolean canPass(List<Terrain> terrains){
        for (int i = 0; i < terrains.size(); i++) {
            if(this.equals(terrains.get(i))){
                return true;
            }
        }
        return false;
    }

    public boolean equals(Terrain terrain){

        if(this.name.equals(terrain.name)){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
