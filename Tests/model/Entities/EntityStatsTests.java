package model.Entities;

import model.Map.Direction;
import org.junit.*;

import java.util.List;

public class EntityStatsTests {


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
        Assert.assertEquals("current health must be set", currentHealth, entityStats.getHealth());


        //take damage
        entityStats.modifyHealth(-20);

        //assert current health decreased
        Assert.assertTrue(currentHealth > entityStats.getHealth());
    }


    @Test
    public void gainExperienceLevelUp() {
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
        Assert.assertEquals("current level must be set", level, entityStats.getLevel());

        //take damage
        entityStats.modifyExperience(1000);

        //assert current health decreased
        Assert.assertTrue(level < entityStats.getLevel());
    }


    @Test
    public void moveChangesPlayerDirection() {
        //setup
        Player player = Player.playerMakeSmasher();
        Direction toChange = player.getDirection().getClockwise(60); //rotate them
        System.out.println("direction to change = " + toChange);

        //affect
        player.move(toChange);

        //assert
        Assert.assertTrue(player.getDirection() == toChange);
    }

    @Test
    public void smasherCorrectSkills(){
        //setup
        Player player = Player.playerMakeSmasher();

        //assert the smasher was initialized with the right skills in order
        List<Skill> skills = player.getSkills();
        for (int i = 0; i < skills.size(); i++) {
            if(i == 0){
                Assert.assertTrue("one-handed weapon".compareTo(skills.get(i).getName()) == 0);
            }
            else if(i == 1){
                Assert.assertTrue("two-handed weapon".compareTo(skills.get(i).getName()) == 0);
            }
            else if(i == 2){
                Assert.assertTrue("brawling".compareTo(skills.get(i).getName()) == 0);
            }
        }

    }
}
