import java.util.HashMap;

import controller.Handlers.MountHandler;
import controller.Handlers.MountPerformer;
import model.Entities.Entity;
import model.Entities.Mount;
import model.Entities.Player;
import model.Map.Direction;
import model.Map.Zone.ContentMap;
import model.Map.Zone.Zone;
import model.Map.Zone.TileRelatedClasses.Tile;

public class MountHandlerTester {
	public static void main(String[] args) {
		Player player = Player.playerMakeSneak();
		Mount mount = new Mount(100);
		
		MountHandler handler = new MountHandler();
		
		
		HashMap<Tile, Entity> map = new HashMap<Tile, Entity>();
		ContentMap<Entity> entityMap = new ContentMap<Entity>(map);
		
		Tile playerTile = new Tile();
		Tile mountTile = new Tile();
		entityMap.setContent(playerTile, player);
		entityMap.setContent(mountTile, mount);
		
		MountPerformer performer = new MountPerformer(entityMap);
		
		handler.setMountPerformer(performer);
		
		handler.mount(player, mount);
		
		System.out.println("Speed Test:\n////////////////////");
		if(player.getMaxSpeed() == 100) {
			System.out.println("True");
			if(entityMap.getContentAtTile(mountTile) == null) {
				System.out.println("NO MOUNT ON MAP");
			}
			else System.out.println("MOUNT ON MAP :("); 
		}
		else System.out.println("False");
		
		HashMap<Direction, Tile> tiles = new HashMap<Direction, Tile>();
		tiles.put(Direction.N, mountTile);
		playerTile.setNeighbors(tiles);
		
		System.out.println("Unmounting Test:\n///////////////");
		handler.unmount(player);
		if(player.getMaxSpeed() == 5) {
			System.out.println("TRUE");
		}
		else System.out.println("FALSE");
		
		if(entityMap.getContentAtTile(mountTile) == player) {
			System.out.println("PLAYER AT RIGHT POSITION! :)");
		}
		else System.out.println("PLAYER AT WRONG POSITION!");
	}

}
