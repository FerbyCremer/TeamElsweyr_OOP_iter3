package controller.Handlers;

import model.Entities.Entity;
import model.Entities.Player;
import model.Items.Takeable.Takeable;
import model.Map.Zone.ContentMap;
import model.Map.Zone.TileRelatedClasses.Tile;

public class StolenHandler {
    private ContentMap<Entity> entityMap;
    private Player player;

    public StolenHandler(ContentMap<Entity> entityMap, Player player){
        this.entityMap = entityMap;
        this.player = player;
    }

    public void giveItem(){
        for(Tile t: entityMap.getTilesContentIsOn()){
            Entity robbed = entityMap.getContentAtTile(t);
            Takeable stolen = robbed.giveStolen();

            if(stolen != null) {
                player.addToInventory(stolen);
            }
        }
    }
}
