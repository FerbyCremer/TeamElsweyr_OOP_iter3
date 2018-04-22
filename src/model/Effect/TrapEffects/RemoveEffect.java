package model.Effect.TrapEffects;

import model.Map.Zone.TileRelatedClasses.Trap;

public class RemoveEffect implements TrapEffect {

    private String name;
    public RemoveEffect(){}

    @Override
    public void apply(Trap trap) {
        trap.setActive();
        //trap.setVisiblity(false);
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
