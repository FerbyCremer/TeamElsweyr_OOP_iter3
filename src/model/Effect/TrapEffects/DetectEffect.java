package model.Effect.TrapEffects;

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
		// TODO Auto-generated method stub
		return null;
	}
}
