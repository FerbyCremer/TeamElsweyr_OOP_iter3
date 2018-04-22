package model.Effect.TrapEffects;

import controller.LoadGame.Saveable;
import model.Map.Zone.TileRelatedClasses.Trap;

public interface TrapEffect extends Saveable{

    void apply(Trap trap);
    public String getName();
}
