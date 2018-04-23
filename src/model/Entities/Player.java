package model.Entities;

import controller.Handlers.BringOutYourDeadHandler;
import controller.Handlers.MountHandler;
import controller.KeyControllers.KeyCommands.*;
import controller.KeyControllers.KeyCommands.MoveKeyListeners.*;
import controller.KeyControllers.KeyControlState;
import controller.KeyControllers.KeyController;
import controller.KeyControllers.ToInventory;
import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;
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
public class Player extends Entity implements Saveable {
    private List<Skill> skills;
    private MountedState mountedState;
    private MountHandler mountHandler;
    private KeyController playerController;
    private String avatar;

    private Player(List<Skill> skills, List<Integer> lvl, EntityStats stats, KeyController playerController, Inventory inventory, List<Terrain> terrains, String name, String avatar, List<KeyCommand> keys, MountHandler mountHandler, BringOutYourDeadHandler deadHandler) {
        super(stats, inventory, terrains, name, deadHandler);
        this.skills = skills;
        mountedState = new Unmounted();

        this.avatar = avatar;

        this.playerController = playerController;
        this.mountHandler = mountHandler;

        int index = lvl.size()-1;

        skills.add(0,new Skill("observation", lvl.remove(index--)));
        skills.add(0,new Skill("bargain", lvl.remove(index--)));
        skills.add(0,new Skill("bindWounds", lvl.remove(index--)));

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

    public String getEntityName(){
        return super.getName();
    }

    public String getName(){
        return this.avatar;
    }

    public void setName(String avatar) { this.avatar = avatar;}

    public static Player playerMakeSmasher(EntityStats stats, List<Integer> lvl, KeyController playerController, Inventory inventory, List<Terrain> terrains, String name, String avatar, MountHandler mountHandler, BringOutYourDeadHandler deadHandler) {
        List<Skill> temp_skills = new ArrayList<Skill>();

        int index = lvl.size()-1;

        temp_skills.add(0, new Skill("oneHanded", lvl.remove(index--)));
        temp_skills.add(0, new Skill("twoHanded", lvl.remove(index--)));
        temp_skills.add(0, new Skill("brawling", lvl.remove(index--)));


        List<KeyCommand> keys = new ArrayList<>();
        Player player = new Player(temp_skills, lvl, stats, playerController, inventory, terrains, name, avatar, keys, mountHandler, deadHandler);

        return player;
    }

    public static Player playerMakeSneak(EntityStats stats, List<Integer> lvl, KeyController playerController, Inventory inventory, List<Terrain> terrains, String name, String avatar, MountHandler mountHandler, BringOutYourDeadHandler deadHandler) {
        List<Skill> temp_skills = new ArrayList<Skill>();

        int index = lvl.size()-1;

        temp_skills.add(0, new Skill("pickPocket", lvl.remove(index--)));
        temp_skills.add(0, new Skill("detectTrap", lvl.remove(index--)));
        temp_skills.add(0, new Skill("removeTrap", lvl.remove(index--)));
        temp_skills.add(0, new Skill("creep", lvl.remove(index--)));
        temp_skills.add(0, new Skill("rangedWeapon", lvl.remove(index--)));

        List<KeyCommand> keys = new ArrayList<>();
        //Add sneak specific commands

        Player player = new Player(temp_skills, lvl, stats, playerController, inventory, terrains, name, avatar, keys, mountHandler, deadHandler);

        return player;
    }

    public static Player playerMakeSummoner(EntityStats stats, List<Integer> lvl, KeyController playerController, Inventory inventory, List<Terrain> terrains, String name, String avatar, MountHandler mountHandler, BringOutYourDeadHandler deadHandler) {
        List<Skill> temp_skills = new ArrayList<Skill>();

        int index = lvl.size()-1;

        temp_skills.add(0, new Skill("enchantment", lvl.remove(index--)));
        temp_skills.add(0, new Skill("boon", lvl.remove(index--)));
        temp_skills.add(0, new Skill("bane",lvl.remove(index--)));
        temp_skills.add(0, new Skill("staff", lvl.remove(index--)));

        List<KeyCommand> keys = new ArrayList<>();
        // Add summoner specific commands
        Player player = new Player(temp_skills, lvl, stats, playerController, inventory, terrains, name, avatar, keys, mountHandler, deadHandler);

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

		@Override
    public String accept(SaveVisitor saveVisitor){
    	return saveVisitor.savePlayer(this);
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
