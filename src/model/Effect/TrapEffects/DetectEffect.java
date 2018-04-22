package model.Effect.TrapEffects;

import controller.LoadGame.SaveVisitor;
import model.Map.Zone.TileRelatedClasses.Trap;

public class DetectEffect implements TrapEffect{

    private String name;
    public DetectEffect(){
        this.name = "";
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
        return getName()+"\n";
    }
}
