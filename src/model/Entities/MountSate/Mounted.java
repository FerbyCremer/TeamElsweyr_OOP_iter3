package model.Entities.MountSate;

import java.util.List;

import model.Entities.EntityStats;
import model.Entities.Mount;
import model.Map.Terrain;

public class Mounted implements MountedState {
	private int speed;
	private List<Terrain> mountPassable;
	private Mount mount;
	
	public Mounted(Mount mount) {
		this.mount = mount;
		speed = mount.getSpeed();
		mountPassable = mount.getPassable();
	}
	
	//setValues changes the player's max speed to the mount's max speed and sets the speed
	//variable in this class to the player's original speed
	@Override
	public void setValues(EntityStats stats) {
		int tempSpeed = stats.getMaxSpeed();
		stats.setMaxSpeed(speed);		
		speed = tempSpeed;
	}
	
	public Mount getMount() {
		return mount;
	}
}
