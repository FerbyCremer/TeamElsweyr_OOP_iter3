package model.Entities;

import controller.Handlers.BringOutYourDeadHandler;
import controller.Handlers.MountHandler;
import controller.KeyControllers.KeyCommands.*;
import controller.KeyControllers.KeyCommands.MoveKeyListeners.*;
import controller.KeyControllers.KeyControlState;
import controller.KeyControllers.KeyController;
import controller.KeyControllers.ToInventory;
import model.Entities.MountSate.Mounted;
import model.Entities.MountSate.MountedState;
import model.Entities.MountSate.Unmounted;
import model.Entities.NPC.NPC;
import model.Inventory.Inventory;
import model.Items.Takeable.Tool;
import model.Map.Terrain;

import java.util.ArrayList;
import java.util.List;

//TODO add playerController
public class Player extends Entity {
    private List<Skill> skills;
    private MountedState mountedState;
    private MountHandler mountHandler;
    private KeyController playerController;

    private Player(List<Skill> skills, EntityStats stats, KeyController playerController, Inventory inventory, List<Terrain> terrains, String name, List<KeyCommand> keys, MountHandler mountHandler, BringOutYourDeadHandler deadHandler) {
        super(stats, inventory, terrains, name, deadHandler);
        this.skills = skills;
        mountedState = new Unmounted();

        this.playerController = playerController;
        this.mountHandler = mountHandler;

        //Add all movement/default commands
        keys.add(new MoveNorthWest(this));
        keys.add(new MoveNorth(this));
        keys.add(new MoveNorthEast(this));
        keys.add(new MoveSouthWest(this));
        keys.add(new MoveSouth(this));
        keys.add(new MoveSouthEast(this));
        keys.add(new BindWounds(this));
        keys.add(new Bargain(this));
        keys.add(new Observe(this));
        keys.add(new Attack(this));
        keys.add(new UnMount(this));


        //Register all keycommands to the playercontroller
        for (KeyCommand command : keys) {
            this.playerController.addKeyListener(command);
        }


    }

    public static Player playerMakeSmasher(EntityStats stats, List<Integer> lvl, KeyController playerController, Inventory inventory, List<Terrain> terrains, String name, MountHandler mountHandler, BringOutYourDeadHandler deadHandler) {
        List<Skill> temp_skills = new ArrayList<Skill>();

        temp_skills.add(new Skill("one-handed weapon"));
        temp_skills.add(new Skill("two-handed weapon"));
        temp_skills.add(new Skill("brawling"));


        List<KeyCommand> keys = new ArrayList<>();
        Player player = new Player(temp_skills, stats, playerController, inventory, terrains, name, keys, mountHandler, deadHandler);

        return player;
    }

    public static Player playerMakeSneak(EntityStats stats, List<Integer> lvl, KeyController playerController, Inventory inventory, List<Terrain> terrains, String name, MountHandler mountHandler, BringOutYourDeadHandler deadHandler) {
        List<Skill> temp_skills = new ArrayList<Skill>();

        temp_skills.add(new Skill("pick-pocket", lvl.get(0)));
        temp_skills.add(new Skill("detect trap", lvl.get(1)));
        temp_skills.add(new Skill("remove trap", lvl.get(2)));
        temp_skills.add(new Skill("creep", lvl.get(3)));
        temp_skills.add(new Skill("rangedWeapon", lvl.get(4)));

        List<KeyCommand> keys = new ArrayList<>();
        //Add sneak specific commands

        Player player = new Player(temp_skills, stats, playerController, inventory, terrains, name, keys, mountHandler, deadHandler);

        return player;
    }

    public static Player playerMakeSummoner(EntityStats stats, List<Integer> lvl, KeyController playerController, Inventory inventory, List<Terrain> terrains, String name, MountHandler mountHandler, BringOutYourDeadHandler deadHandler) {
        List<Skill> temp_skills = new ArrayList<Skill>();

        temp_skills.add(new Skill("enchantment"));
        temp_skills.add(new Skill("boon"));
        temp_skills.add(new Skill("bane"));
        temp_skills.add(new Skill("staff"));

        List<KeyCommand> keys = new ArrayList<>();
        // Add summoner specific commands
        Player player = new Player(temp_skills, stats, playerController, inventory, terrains, name, keys, mountHandler, deadHandler);

        return player;
    }

    public double getModifier(Skill skill) {
        for (Skill s : skills) {
            if (s.equals(skill)) {
                return s.getModifier();
            }
        }

        return 0;
    }

    //Tells the inventory to use the tool at the indexz
    public void attack() {
        inventory.useTool(this);
    }

    public void useSkill(int skill) {
    }

    //Tells the inventory to use the currently equipped consumable
    public void consumeItem() {
        inventory.useConsumable(this);
    }

    //TODO do this after figuring out inventory
    /*public Tool getToolAtIndex(int toolIndex){

    }*/

    public void swapState(MountedState mountedState) {
        this.mountedState = mountedState;
        execute();
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setMountHandler(MountHandler mountHandler) {
        this.mountHandler = mountHandler;
        execute();
    }

    public void Unmount() {
        mountHandler.unmount(this);
    }

    public Mount getMount() {
        return ((Mounted) mountedState).getMount();
    }


    public void visit(NPC npc) {
        npc.doInteraction(this);
    }

    public void visit(Mount mount) {
        mountHandler.mount(this, mount);
    }

//	public void visit(Pet pet){
//
//	}
}
