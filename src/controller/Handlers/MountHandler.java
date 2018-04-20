package controller.Handlers;

import model.Entities.Mount;
import model.Entities.Player;
import model.Entities.MountSate.Mounted;
import model.Entities.MountSate.MountedState;
import model.Map.Zone.Zone;

public class MountHandler {
	//TODO create a MountPerformer class
	private MountPerformer mountPerformer;
	
	public void mount(Player player, Mount mount) {
		mountPerformer.performMounting(player, mount);
	}
	
	public void unmount(Player player) {
		mountPerformer.performUnmounting(player);
	}
	
	public void setMountPerformer(Zone zone) {
		mountPerformer = new MountPerformer(zone);
	}

	//TODO delete this testing purposes only
	public void setMountPerformer(MountPerformer performer) {
		mountPerformer = performer;		
	}
}
