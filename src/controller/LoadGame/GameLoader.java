package controller.LoadGame;

import controller.MapControllers.WorldController;
import model.Effect.EntityEffect.EntityEffect;
import model.Entities.Entity;
import model.Entities.EntityStats;
import model.Inventory.Inventory;
import model.Items.Item;
import model.Items.Takeable.Takeable;
import model.Map.Direction;
import model.Map.Terrain;
import model.Map.World;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.*;
import model.Map.Zone.Zone;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GameLoader {


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
                while (worldData.get(lineIndex++).equals("takeable")){
                    List<String> itemData = new ArrayList<>();
                    do {
                        itemData.add(worldData.get(lineIndex));
                    } while (!worldData.get(lineIndex++).equals("endOfTakeable"));

                    //TODO get item from itembuilder
                    //items.add()
                }
                Inventory inventory = new Inventory(entityStats, wealth, items);

                //READ Passable
                lineIndex++;
                List<Terrain> passable = new ArrayList<>();
                do {
                    Terrain terrain = new Terrain(worldData.get(lineIndex));
                    passable.add(terrain);

                } while (!worldData.get(lineIndex++).equals("endOfPassable"));


                String entityType = worldData.get(lineIndex++);

                //Get info for entity builder
                List<String> entityTypeData = new ArrayList<>();
                do {
                    entityTypeData.add(worldData.get(lineIndex));

                } while (!worldData.get(lineIndex++).equals("endOfEntityType"));

                //TODO
                Entity entity = null;
                switch (entityType) {
                    case "player":
                        //entity = entityBuilder.buildPlayer(entityTypeData);
                        //setPlayer((Player) entity);
                        break;
                    case "npc":
                        //entity = entityBuilder.buildNPC(entityTypeData);
                        break;
                    case "pet":
                        //entity = entityBuilder.buildNPC(entityTypeData);
                        break;
                    case "mount":
                        //entity = entityBuilder.buildNPC(entityTypeData);
                        break;
                }

                entityMap.setNewLocation(tiles[x][y], entity);
                //Inventory inventory = new Inventory()

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

                //TODO Get item from itembuilder
                Item item = null;

                itemMap.setNewLocation(tiles[x][y], item);
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

                //TODO Get effect builder
                EntityEffect effect = null;

                AreaEffect areaEffect = new AreaEffect(effect);
                areaEffectMap.setNewLocation(tiles[x][y], areaEffect);
            }
            //ENDAREAEFFECTMAP

            //RIVERMAP
            while (worldData.get(lineIndex++).equals("riverMap")){
                int x = Integer.parseInt(worldData.get(lineIndex++));
                int y = Integer.parseInt(worldData.get(lineIndex++));
                int flowRate = Integer.parseInt(worldData.get(lineIndex++));
                int angle = Integer.parseInt(worldData.get(lineIndex++));

                Direction flowDirection;
                switch (angle){
                    case 0:
                        flowDirection = Direction.N;
                        break;
                    case 60:
                        flowDirection = Direction.NE;
                        break;
                    case 120:
                        flowDirection = Direction.SE;
                        break;
                    case 180:
                        flowDirection = Direction.S;
                        break;
                    case 240:
                        flowDirection = Direction.SW;
                        break;
                    case 300:
                        flowDirection = Direction.NW;
                        break;
                    default:
                        flowDirection = Direction.N;
                }
                River river = new River(flowRate, flowDirection);
                riverMap.setNewLocation(tiles[x][y], river);
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

                //TODO Get effect builder
                EntityEffect effect = null;

                Trap trap = new Trap(visible, active, effect);
                trapMap.setNewLocation(tiles[x][y], trap);

            }
            //ENDTRAP

            //DECALMAP
            while (worldData.get(lineIndex++).equals("decalMap")){
                int x = Integer.parseInt(worldData.get(lineIndex++));
                int y = Integer.parseInt(worldData.get(lineIndex++));

                String decalData = worldData.get(lineIndex++);
                Decal decal = new Decal(decalData);
                decalMap.setNewLocation(tiles[x][y], decal);

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

        //TODO DO SOMETHING




    }

    public WorldController load(){
        String filepath = "/src/saves/savefile.txt";

        //return new WorldController();
        return null;
    }


    public WorldController load(String name, int avatar){

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
    	//Add NW
	     if (col - 1 >= 0) {
	    	 neighbors.put(Direction.NW, tiles[row][col-1]);
         }
         else {
        	 neighbors.put(Direction.NW, null);
         }

         //Add N
         if (row - 1 >= 0) {
             neighbors.put(Direction.N, tiles[row-1][col]);
         }
         else {
        	 neighbors.put(Direction.N, null);
         }

         //Add NE
         if (col + 1 < colCount) {
             neighbors.put(Direction.NE, tiles[row][col+1]);
         }
         else {
        	 neighbors.put(Direction.NE, null);
         }
         
         //Add SW
         if (row + 1 < rowCount && col - 1 >= 0) {
             neighbors.put(Direction.SW, tiles[row+1][col-1]);
         }
         else {
        	 neighbors.put(Direction.SW, null);
         }

         //Add S
         if (row + 1 < rowCount) {
         	neighbors.put(Direction.S, tiles[row+1][col]);
         }
         else {
         	neighbors.put(Direction.S, null);
         }

         //Add SE
         if (row + 1 < rowCount && col + 1 < colCount) {
             neighbors.put(Direction.SE, tiles[row+1][col+1]);
         }
         else {
        	 neighbors.put(Direction.SE, null);
         }

         tiles[row][col].setNeighbors(neighbors);
    }
    
    private void oddColNeighbors(int row, int col, int rowCount, int colCount, HashMap<Direction, Tile> neighbors, Tile tiles[][]) {
    	//Add NW
    	if (col - 1 >= 0 && row-1 >= 0) {
    		neighbors.put(Direction.NW, tiles[row-1][col-1]);
    	}
    	else {
    		neighbors.put(Direction.NW, null);
    	}

    	//Add N
    	if (row - 1 >= 0) {
    		neighbors.put(Direction.N, tiles[row-1][col]);
    	}
    	else {
    		neighbors.put(Direction.N, null);
    	}

    	//Add NE
    	if (col + 1 < colCount && row - 1 >= 0) {
    		neighbors.put(Direction.NE, tiles[row-1][col+1]);
    	}
    	else {
    		neighbors.put(Direction.NE, null);
    	}
      
    	//Add SW
    	if (col - 1 >= 0) {
    		neighbors.put(Direction.SW, tiles[row][col-1]);
    	}
    	else {
    		neighbors.put(Direction.SW, null);
    	}

    	//Add S
    	if (row + 1 < rowCount) {
    		neighbors.put(Direction.S, tiles[row+1][col]);
    	}
    	else {
    		neighbors.put(Direction.S, null);
    	}

    	//Add SE
    	if (col + 1 < colCount) {
    		neighbors.put(Direction.SE, tiles[row][col+1]);
    	}
    	else {
    		neighbors.put(Direction.SE, null);
    	}

    	tiles[row][col].setNeighbors(neighbors);
    }
}
