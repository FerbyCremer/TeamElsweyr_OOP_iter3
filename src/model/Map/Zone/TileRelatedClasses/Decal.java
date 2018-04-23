package model.Map.Zone.TileRelatedClasses;

import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;

public class Decal implements Saveable{
    private String fileName;

    public Decal(String fileName) {
        this.fileName = fileName;
    }

    public String getDecal() {
        return fileName;
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveDecal(this);
    }
}
