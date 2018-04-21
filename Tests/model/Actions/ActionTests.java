package model.Actions;

import model.Effect.EntityEffect.EntityEffect;
import model.Effect.EntityEffect.HealEffect;
import model.Map.Direction;
import model.Map.Zone.TileRelatedClasses.Tile;
import model.Map.Zone.Zone;
import org.junit.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ActionTests {

    @Test
    public void listLengthOneWhenMaxRangeOneTest(){
        //Setup
        Action action = new EntityAction(1, 1, new HealEffect(10));

//        Zone zone = new Zone()
        //When zone is finalized pass a tile form a made up content map. make it in @before

        //Assert
        HashMap<Tile, Integer> map = action.getAffectedTiles(null, null);
        Set<Tile> set = map.keySet();
        Assert.assertTrue(set.size() < 2);
    }
}
