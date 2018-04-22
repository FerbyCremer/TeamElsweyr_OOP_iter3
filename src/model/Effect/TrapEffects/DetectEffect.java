package model.Effect.TrapEffects;

import controller.LoadGame.SaveVisitor;
import model.Map.Zone.TileRelatedClasses.Trap;

public class DetectEffect implements TrapEffect{

    public DetectEffect(){

    }
    @Override
    public void apply(Trap trap) {
        trap.setVisiblity(true);
    }

    @Override
    public String getName() {
        return "detectEffect";
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveTrapEffect(this);
    }
}
