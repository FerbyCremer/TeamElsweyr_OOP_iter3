package model.Entities.MountSate;

import model.Entities.EntityStats;
import model.Map.Terrain;

import java.util.List;

public interface MountedState {
	public void setValues(EntityStats stats);
	List<Terrain> getTerrains();
}
