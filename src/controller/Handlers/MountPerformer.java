package controller.Handlers;

import model.Entities.Entity;
import model.Entities.Mount;
import model.Entities.Player;
import model.Entities.MountSate.Mounted;
import model.Entities.MountSate.MountedState;
import model.Entities.MountSate.Unmounted;
import model.Map.Direction;
import model.Map.Zone.ContentMap;
import model.Map.Zone.Zone;
import model.Map.Zone.TileRelatedClasses.Tile;

public class MountPerformer {
	private ContentMap<Entity> entityMap;
	
	public MountPerformer(Zone zone) {
		entityMap = zone.getEntityMap();
	}

	public void performMounting(Player player, Mount mount) {
		MountedState mounted = new Mounted(mount);
		
		player.swapState(mounted);
		mounted.setValues(player.getStats());
		Tile tile = entityMap.getTileOf(mount);

		entityMap.removeContent(mount);
		entityMap.setNewLocation(tile, player);
	}
	
	public void performUnmounting(Player player) {
		MountedState unmounted = new Unmounted();
		
		Mount mount = player.getMount();
		Tile tempTile = entityMap.getTileOf(player);
		
		//TODO find a better way to get the tile to move the player as this is an LoD violation
		//TODO it can also cause bugs depending where the player unmounts
		entityMap.setNewLocation(tempTile.getNeighbor(Direction.N), player);
		entityMap.setContent(tempTile, mount);
				
				
		player.swapState(unmounted);
		unmounted.setValues(player.getStats());
	}

}
