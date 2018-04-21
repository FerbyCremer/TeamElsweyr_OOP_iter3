package model.Entities;

import model.Actions.Action;
import model.Inventory.Inventory;
import model.Items.Item;
import model.Items.Takeable.Takeable;
import model.Items.Takeable.Tool;
import model.Map.Direction;
import org.junit.*;

public class PlayerTests {

    @Before
    public void setup(){
        //nothing right now
    }


    @Test
    public void modifyMaxHealthIncreasesHealthTest() {
        int maxHealth = 100;
        int currentHealth = 90;
        int level = 10;
        int experience = 10;
        int defense = 10;
        int detectRange = 15;
        int currentSpeed = 0;

        //int maxHealth, int currentHealth, int level, int experience, int defense, int detectRange, int currentSpeed, Direction facingDirection
        EntityStats entityStats = new EntityStats(maxHealth, currentHealth, level, experience, defense, detectRange, currentSpeed, Direction.N); // MyClass is tested

        // assert statements
        Assert.assertEquals("current hp must be set", currentHealth, entityStats.getHealth());


        //take damage
        entityStats.modifyHealth(-20);

        //assert current health decreased
        Assert.assertTrue(currentHealth > entityStats.getHealth());
    }


    @Test
    public void successfulAddToInventory() {
        int maxHealth = 100;
        int currentHealth = 90;
        int level = 1;
        int experience = 10;
        int defense = 10;
        int detectRange = 15;
        int currentSpeed = 0;

        //int maxHealth, int currentHealth, int level, int experience, int defense, int detectRange, int currentSpeed, Direction facingDirection
        EntityStats entityStats = new EntityStats(maxHealth, currentHealth, level, experience, defense, detectRange, currentSpeed, Direction.N); // MyClass is tested

        Player player = Player.playerMakeSmasher();

        Tool tool = new Tool(null, null,  null, 5);
        player.addToInventory(tool);

        //Get inventory
        Inventory inventory = player.getInventory();

        //Tool
        Takeable item = inventory.getItem(0);

        //assert item was added decreased
        Assert.assertTrue(item == tool);
    }


    @Test
    public void slowEffect() {
        int maxHealth = 100;
        int currentHealth = 90;
        int level = 1;
        int experience = 10;
        int defense = 10;
        int detectRange = 15;
        int currentSpeed = 0;

        //int maxHealth, int currentHealth, int level, int experience, int defense, int detectRange, int currentSpeed, Direction facingDirection
        EntityStats entityStats = new EntityStats(maxHealth, currentHealth, level, experience, defense, detectRange, currentSpeed, Direction.N); // MyClass is tested

        // assert statements
        Assert.assertEquals("current spd must be set", currentSpeed, entityStats.getCurrentSpeed());


        //take damage
        entityStats.modifyCurrentSpeed(-1);


        //assert current health decreased
        Assert.assertTrue(currentSpeed > entityStats.getCurrentSpeed());
    }
}
