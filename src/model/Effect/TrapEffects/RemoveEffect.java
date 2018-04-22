package model.Effect.TrapEffects;

import controller.LoadGame.SaveVisitor;
import model.Map.Zone.TileRelatedClasses.Trap;

public class RemoveEffect implements TrapEffect {

    public RemoveEffect(){}

    @Override
    public void apply(Trap trap) {
        trap.setActive();
        //trap.setVisiblity(false);
    }

    @Override
    public String getName() {
        return "removeEffect";
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return saveVisitor.saveTrapEffect(this);
    }

}
