package controller.LoadGame;

import controller.EntityControllers.AIController;
import controller.Handlers.ActionHandler;
import controller.Handlers.BringOutYourDeadHandler;
import controller.Handlers.MountHandler;
import controller.KeyControllers.KeyBindingMapper;
import controller.KeyControllers.KeyCommands.KeyCommand;
import controller.KeyControllers.KeyCommands.MoveKeyListeners.MoveNorth;
import controller.KeyControllers.KeyControlState;
import controller.KeyControllers.KeyController;
import controller.KeyControllers.ToInventory;
import controller.MapControllers.WorldController;
import controller.MapControllers.ZoneController;
import controller.ViewControllers.GameObserver;
import javafx.scene.Camera;
import javafx.scene.Scene;
import model.Actions.ActionType.ActionInterface;
import model.Actions.ActionType.ActionObserver;
import model.Effect.EntityEffect.EntityEffect;
import model.Effect.EntityEffect.ObserveObserver;
import model.Entities.AI;
import model.Entities.Entity;
import model.Entities.EntityStats;
import model.Entities.Player;
import model.Inventory.Inventory;
import model.Items.Item;
import model.Items.Takeable.Takeable;
import model.Map.Direction;
import model.Map.Terrain;
import model.Map.World;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.*;
import model.Map.Zone.Zone;
import view.InventoryObserver;
import view.ZoneView;
import javafx.scene.canvas.Canvas;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GameLoader {


    private Canvas canvas;
    private GameObserver gameObserver;
    private InventoryObserver inventoryObserver;

    private KeyControlState keyControlState;

    private WorldController worldController;
    private ZoneView zoneView;
    private ActionHandler actionHandler;
    private MountHandler mountHandler;
    private BringOutYourDeadHandler deadHandler;

    private KeyBindingMapper keyBindingMapper;
    private KeyController playerController;


    private KeyController cameraController;
    private KeyController inventoryController;

    private AIController aiController;

    private EffectBuilder effectBuilder;
    private ItemBuilder itemBuilder;
    private EntityBuilder entityBuilder;




    public GameLoader(Canvas canvas, GameObserver gameObserver, Camera camera){

        this.canvas = canvas;
        this.gameObserver = gameObserver;
        //Initialize Controllers
        ActionInterface actionInterface = new ActionObserver();
        actionHandler = new ActionHandler(actionInterface);
        mountHandler = new MountHandler();
        keyBindingMapper = new KeyBindingMapper("src/assets/saves/keybinds.txt");
        playerController = new KeyController("player", keyBindingMapper);
        aiController = new AIController();
        zoneView = new ZoneView(canvas, camera);
        zoneView.setActionInterface(actionInterface);
       // worldController = new WorldController(new ZoneController(zoneView), actionHandler, mountHandler, deadHandler, aiController);
        deadHandler = new BringOutYourDeadHandler(aiController);
        worldController = new WorldController(new ZoneController(zoneView, aiController), actionHandler, mountHandler, deadHandler);
        //Initialize builders
        effectBuilder = new EffectBuilder(worldController, zoneView);
        itemBuilder = new ItemBuilder(actionHandler, effectBuilder);
        entityBuilder = new EntityBuilder(deadHandler);
    }


    public KeyController initializeKeyController(Scene scene){
        //playerController.addKeyListener(new ToInventory("ToInventory", keyControlState));
        //TODO add all basic keycommands intialization
        //Make key commands
/*        List<KeyCommand> cameraCommands = new ArrayList<>();
        cameraController = new KeyController("camera", cameraCommands);

        //Make key commands
        List<KeyCommand> inventoryCommands = new ArrayList<>();
        inventoryController = new KeyController("inventory", inventoryCommands);*/

       // keyControlState = new KeyControlState(scene, playerController, cameraController, inventoryController);
        scene.setOnKeyPressed(playerController);

        return playerController;
    }

    private Loader loader = new Loader();


    public void parseFile(String filepath){

        List<String> worldData = new ArrayList<>();

        Scanner s = null;
        try {
            s = new Scanner(new File(filepath));
            while (s.hasNextLine()){
                worldData.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Read World
        int lineIndex = 1;
        //worldData.get(lineIndex++).equals("");
        //Integer.parseInt(worldData.get(lineIndex++))


        List<Zone> allZones = new ArrayList<>();

        //ZONES
        while (worldData.get(lineIndex++).equals("zone")){
            String id = worldData.get(lineIndex++);
            Point spawnPoint = new Point(Integer.parseInt(worldData.get(lineIndex++)), Integer.parseInt(worldData.get(lineIndex++)));
            int numRows = Integer.parseInt(worldData.get(lineIndex++));
            int numCols = Integer.parseInt(worldData.get(lineIndex++));

            Tile[][] tiles = new Tile[numRows][numCols];
            ContentMap<Decal> decalMap = new ContentMap<>();
            ContentMap<Entity> entityMap = new ContentMap<>();
            ContentMap<Item> itemMap = new ContentMap<>();
            ContentMap<AreaEffect> areaEffectMap = new ContentMap<>();
            ContentMap<Trap> trapMap = new ContentMap<>();
            ContentMap<River> riverMap = new ContentMap<>();

            //TILES
            while (worldData.get(lineIndex++).equals("tile")){
                String terrainType = worldData.get(lineIndex++);
                Terrain terrain = new Terrain(terrainType);
                Boolean obstacle = Boolean.parseBoolean(worldData.get(lineIndex++));
                int x = Integer.parseInt(worldData.get(lineIndex++));
                int y = Integer.parseInt(worldData.get(lineIndex++));
                tiles[x][y] = new Tile(terrain, obstacle, new Point(x,y));
            }
            setNeighborhood(tiles);
            //END TILES

            //ENTITYMAP
            while (worldData.get(lineIndex++).equals("entityMap")){
                int x = Integer.parseInt(worldData.get(lineIndex++));
                int y = Integer.parseInt(worldData.get(lineIndex++));

                //READ entitystats
                lineIndex++;
                int maxHealth = Integer.parseInt(worldData.get(lineIndex++));
                int currentHealth = Integer.parseInt(worldData.get(lineIndex++));
                int level = Integer.parseInt(worldData.get(lineIndex++));
                int experience = Integer.parseInt(worldData.get(lineIndex++));
                int defense = Integer.parseInt(worldData.get(lineIndex++));
                int detectRange = Integer.parseInt(worldData.get(lineIndex++));
                int currentSpeed = Integer.parseInt(worldData.get(lineIndex++));
                EntityStats entityStats = new EntityStats(maxHealth, currentHealth, level, experience, defense, detectRange, currentSpeed);

                //READ Inventory
                lineIndex++;
                int wealth = Integer.parseInt(worldData.get(lineIndex++));
                List<Takeable> items = new ArrayList<>();
                //read in items
                while (worldData.get(lineIndex++).equals("item")){
                    List<String> itemData = new ArrayList<>();
                    do {
                        itemData.add(worldData.get(lineIndex));
                    } while (!worldData.get(lineIndex++).equals("endOfTakeable"));
                    items.add((Takeable) itemBuilder.buildItem(itemData));
                }
                Inventory inventory = new Inventory(entityStats, wealth, items);

                //READ Passable
                lineIndex++;
                List<Terrain> passable = new ArrayList<>();
                do {
                    Terrain terrain = new Terrain(worldData.get(lineIndex));
                    passable.add(terrain);

                } while (!worldData.get(lineIndex++).equals("endOfPassable"));
                passable.remove(passable.size()-1);

                String entityType = worldData.get(lineIndex++);
                //Get info for entity builder
                List<String> entityTypeData = new ArrayList<>();
                do {
                    entityTypeData.add(worldData.get(lineIndex));
                } while (!worldData.get(lineIndex++).equals("endOfEntityType"));

                Entity entity = null;
                switch (entityType) {
                    case "player":
                        String avatar = worldData.get(lineIndex++);
                        entity = entityBuilder.buildPlayer(entityTypeData, playerController, inventory, avatar, passable, mountHandler, entityStats);
                        //TODO store global reference to player somewhere?
                        aiController.setPlayer((Player) entity);
                        worldController.setPlayer((Player) entity);
                        gameObserver.setPlayer((Player) entity);
                        inventoryObserver = new InventoryObserver(inventory);
                        inventory.add(inventoryObserver);
                        break;
                    case "npc":
                        entity = entityBuilder.buildNPC(entityTypeData, aiController, inventory, passable, entityStats);
                        aiController.addAI((AI) entity );
                        break;
                    case "pet":
                        entity = entityBuilder.buildPet(entityTypeData, aiController, inventory, passable, entityStats);
                        aiController.addAI((AI) entity );
                        break;
                    case "mount":
                        entity = entityBuilder.buildMount(entityTypeData, inventory, passable, entityStats);
                        break;
                }
                entityMap.setContent(tiles[x][y], entity);
            }
            //ENDENTITYMAP

            //ITEMMAP
            while (worldData.get(lineIndex++).equals("itemMap")){
                int x = Integer.parseInt(worldData.get(lineIndex++));
                int y = Integer.parseInt(worldData.get(lineIndex++));


                //Get info for item builder
                List<String> itemData = new ArrayList<>();
                do {
                    itemData.add(worldData.get(lineIndex));

                } while (!worldData.get(lineIndex++).equals("endOfItem"));

                Item item = itemBuilder.buildItem(itemData);

                itemMap.setContent(tiles[x][y], item);
            }
            //ENDITEMMAP

            //AREAEFFECTMAP
            while (worldData.get(lineIndex++).equals("areaEffectMap")){
                int x = Integer.parseInt(worldData.get(lineIndex++));
                int y = Integer.parseInt(worldData.get(lineIndex++));


                //Get info for effect builder
                List<String> effectData = new ArrayList<>();
                do {
                    effectData.add(worldData.get(lineIndex));

                } while (!worldData.get(lineIndex++).equals("endOfEffect"));

                EntityEffect effect = effectBuilder.buildEntityEffect(effectData);
                AreaEffect areaEffect = new AreaEffect(effect);
                areaEffectMap.setContent(tiles[x][y], areaEffect);
            }
            //ENDAREAEFFECTMAP

            //RIVERMAP
            while (worldData.get(lineIndex++).equals("riverMap")){
                int x = Integer.parseInt(worldData.get(lineIndex++));
                int y = Integer.parseInt(worldData.get(lineIndex++));
                int flowRate = Integer.parseInt(worldData.get(lineIndex++));
                int angle = Integer.parseInt(worldData.get(lineIndex++));

                Direction flowDirection = Direction.N.getClockwise(angle);
                River river = new River(flowRate, flowDirection);
                riverMap.setContent(tiles[x][y], river);
            }
            //ENDRIVERMAP

            //TRAPMAP
            while (worldData.get(lineIndex++).equals("trapMap")){
                int x = Integer.parseInt(worldData.get(lineIndex++));
                int y = Integer.parseInt(worldData.get(lineIndex++));

                boolean visible = Boolean.parseBoolean(worldData.get(lineIndex++));
                boolean active = Boolean.parseBoolean(worldData.get(lineIndex++));

                //Get info for effect builder
                List<String> effectData = new ArrayList<>();
                do {
                    effectData.add(worldData.get(lineIndex));

                } while (!worldData.get(lineIndex++).equals("endOfEffect"));

                EntityEffect effect = effectBuilder.buildEntityEffect(effectData);
                Trap trap = new Trap(visible, active, effect);
                trapMap.setContent(tiles[x][y], trap);

            }
            //ENDTRAP

            //DECALMAP
            while (worldData.get(lineIndex++).equals("decalMap")){
                int x = Integer.parseInt(worldData.get(lineIndex++));
                int y = Integer.parseInt(worldData.get(lineIndex++));

                String decalData = worldData.get(lineIndex++);
                Decal decal = new Decal(decalData);
                decalMap.setContent(tiles[x][y], decal);

            }
            //ENDDECALMAP


            Zone zone = new Zone(id, tiles, decalMap, entityMap, itemMap, areaEffectMap, trapMap, riverMap, spawnPoint);
            allZones.add(zone);
        }
        //END ZONES

        String currentZoneID = worldData.get(lineIndex++);
        Zone currentZone = null;
        //Fine zone with that id
        for (Zone zone : allZones) {
            if (zone.getID().equals(currentZoneID)) {
                currentZone = zone;
                break;
            }
        }

        World theWorld = new World(allZones, currentZone);
        worldController.setWorld(theWorld);
        worldController.setDecalSetContainer();
        worldController.updateWorldController(currentZoneID);
        //TODO DO SOMETHING

    }

    public WorldController load(){
        String filepath = "src/assets/saves/savefile3.txt";
        parseFile(filepath);

        //TODO do this here or in menu to get KeyControlState reference
        //initializeKeyControlState();
        return worldController;
    }


    public WorldController load(String name, int avatar){
        //String filepath = "src/assets/saves/savefile.txt";

        return null;
    }

    public void setNeighborhood(Tile[][] tiles) {
    	
    	int collumnCount = tiles[0].length;
    	int rowCount = tiles.length;

    	for (int row = 0; row < rowCount; row++) {
    		for (int collumn = 0; collumn < collumnCount; collumn++) {
    			HashMap<Direction, Tile> neighbors = new HashMap<Direction, Tile>();

    			if(collumn%2 == 0) {
    				evenColNeighbors(row, collumn, rowCount, collumnCount, neighbors, tiles);
    			}
    			else {
    				oddColNeighbors(row, collumn, rowCount, collumnCount, neighbors, tiles);
    			}
            }
        }
    }

    private void evenColNeighbors(int row, int col, int rowCount, int colCount, HashMap<Direction, Tile> neighbors, Tile tiles[][]) {
    	//NW
	     if (col - 1 >= 0) {
	    	 neighbors.put(Direction.NW, tiles[row][col-1]);
         }
         else {
        	 neighbors.put(Direction.NW, null);
         }

         //N
         if (row - 1 >= 0) {
             neighbors.put(Direction.N, tiles[row-1][col]);
         }
         else {
        	 neighbors.put(Direction.N, null);
         }

         //NE
         if (col + 1 < colCount) {
             neighbors.put(Direction.NE, tiles[row][col+1]);
         }
         else {
        	 neighbors.put(Direction.NE, null);
         }

         //SW
         if (row + 1 < rowCount && col - 1 >= 0) {
             neighbors.put(Direction.SW, tiles[row+1][col-1]);
         }
         else {
        	 neighbors.put(Direction.SW, null);
         }

         //S
         if (row + 1 < rowCount) {
         	neighbors.put(Direction.S, tiles[row+1][col]);
         }
         else {
         	neighbors.put(Direction.S, null);
         }

         //SE
         if (row + 1 < rowCount && col + 1 < colCount) {
             neighbors.put(Direction.SE, tiles[row+1][col+1]);
         }
         else {
        	 neighbors.put(Direction.SE, null);
         }

         tiles[row][col].setNeighbors(neighbors);
    }

    private void oddColNeighbors(int row, int col, int rowCount, int colCount, HashMap<Direction, Tile> neighbors, Tile tiles[][]) {
    	//NW
    	if (col - 1 >= 0 && row-1 >= 0) {
    		neighbors.put(Direction.NW, tiles[row-1][col-1]);
    	}
    	else {
    		neighbors.put(Direction.NW, null);
    	}

    	//N
    	if (row - 1 >= 0) {
    		neighbors.put(Direction.N, tiles[row-1][col]);
    	}
    	else {
    		neighbors.put(Direction.N, null);
    	}

    	//NE
    	if (col + 1 < colCount && row - 1 >= 0) {
    		neighbors.put(Direction.NE, tiles[row-1][col+1]);
    	}
    	else {
    		neighbors.put(Direction.NE, null);
    	}

    	//SW
    	if (col - 1 >= 0) {
    		neighbors.put(Direction.SW, tiles[row][col-1]);
    	}
    	else {
    		neighbors.put(Direction.SW, null);
    	}

    	//S
    	if (row + 1 < rowCount) {
    		neighbors.put(Direction.S, tiles[row+1][col]);
    	}
    	else {
    		neighbors.put(Direction.S, null);
    	}

    	//SE
    	if (col + 1 < colCount) {
    		neighbors.put(Direction.SE, tiles[row][col+1]);
    	}
    	else {
    		neighbors.put(Direction.SE, null);
    	}

    	tiles[row][col].setNeighbors(neighbors);
    }
}
