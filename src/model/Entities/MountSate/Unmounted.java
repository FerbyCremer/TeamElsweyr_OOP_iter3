package model.Entities.MountSate;

import java.util.ArrayList;
import java.util.List;

import model.Entities.EntityStats;
import model.Map.Terrain;

public class Unmounted implements MountedState {
	private int originalSpeed;
	private List<Terrain> originalPassable;
	
	public Unmounted() {
		originalSpeed = 5;
		originalPassable = new ArrayList<Terrain>();
		originalPassable.add(new Terrain("grass"));
	}
	
	@Override
	public void setValues(EntityStats stats) {
		stats.setMaxSpeed(originalSpeed);
	}

	@Override
	public List<Terrain> getTerrains(){
		return originalPassable;
	}
}
