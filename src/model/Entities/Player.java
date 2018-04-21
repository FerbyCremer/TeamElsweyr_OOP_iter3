package model.Entities;

import controller.Handlers.BringOutYourDeadHandler;
import controller.Handlers.MountHandler;
import controller.KeyControllers.KeyCommands.KeyCommand;
import controller.KeyControllers.KeyController;
import model.Entities.MountSate.Mounted;
import model.Entities.MountSate.MountedState;
import model.Entities.MountSate.Unmounted;
import model.Entities.NPC.NPC;
import model.Items.Takeable.Tool;

import java.util.ArrayList;
import java.util.List;

//TODO add playerController
public class Player extends Entity{
    private List<Skill> skills;
    private MountedState mountedState;
    private MountHandler mountHandler;
    private KeyController playerController;

    private Player(List<Skill> skills, EntityStats stats, BringOutYourDeadHandler deadHandler){
    	super(stats, deadHandler);
    	this.skills = skills;
    	mountedState = new Unmounted();

		this.playerController = new KeyController("player", );
    }

    public static Player playerMakeSmasher(EntityStats stats, BringOutYourDeadHandler deadHandler){
    	List<Skill> temp_skills = new ArrayList<Skill>();
    	
    	temp_skills.add(new Skill("one-handed weapon"));
    	temp_skills.add(new Skill("two-handed weapon"));
    	temp_skills.add(new Skill("brawling"));

    	Player player = new Player(temp_skills, stats, deadHandler);

    	return player;
    }

    public static Player playerMakeSneak(EntityStats stats, BringOutYourDeadHandler deadHandler){
    	List<Skill> temp_skills = new ArrayList<Skill>();
    	
    	temp_skills.add(new Skill("pick-pocket"));
    	temp_skills.add(new Skill("detect trap"));
    	temp_skills.add(new Skill("remove trap"));
    	temp_skills.add(new Skill("creep"));
    	temp_skills.add(new Skill("rangedWeapon"));
    	
    	Player player = new Player(temp_skills, stats, deadHandler);
		List<KeyCommand> keys = new ArrayList<>();
		//keys.add()
    	
    	return player;
    }
    
    public static Player playerMakeSummoner(EntityStats stats, BringOutYourDeadHandler deadHandler){
    	List<Skill> temp_skills = new ArrayList<Skill>();
    	
    	temp_skills.add(new Skill("enchantment"));
    	temp_skills.add(new Skill("boon"));
    	temp_skills.add(new Skill("bane"));
    	temp_skills.add(new Skill("staff"));
    	
    	Player player = new Player(temp_skills, stats, deadHandler);
    	
    	return player;
    }

    public double getModifier(Skill skill){
    	for(Skill s: skills) {
    		if(s.equals(skill)) {
    			return s.getModifier();
    		}
    	}
    	
    	return 0;
    }

    //Tells the inventory to use the tool at the indexz
    public void attack(int index){
    	inventory.useTool(index, this);
    }

    public void useSkill(int skill){}

    //Tells the inventory to use the currently equipped consumable
    public void consumeItem(){
    	inventory.useConsumable(this);
    }

    //TODO do this after figuring out inventory
    /*public Tool getToolAtIndex(int toolIndex){
    	
    }*/

    public void swapState(MountedState mountedState){
    	this.mountedState = mountedState;
    }

    public List<Skill> getSkills(){
        return skills;
    }

    private void addSkillToolToInventory(Tool tool){
    	inventory.equipInvisibleTool(tool);
    }
    
    public void setMountHandler(MountHandler mountHandler) {
    	this.mountHandler = mountHandler;
    }
    
    public void Unmount() {
    	mountHandler.unmount(this);
    }
    
    public Mount getMount() {
    	return ((Mounted)mountedState).getMount();
    }


	public void visit(NPC npc){
    	npc.doInteraction(this);
	}

	public void visit(Mount mount){
		mountHandler.mount(this, mount);
	}

//	public void visit(Pet pet){
//
//	}
}
