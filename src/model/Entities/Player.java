package model.Entities;

import controller.EntityControllers.PlayerController;
import controller.Handlers.MountHandler;
import model.Entities.MountSate.MountedState;
import model.Items.Takeable.Tool;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Skill> skills;
    private MountedState mountedState;
    private MountHandler mountHandler;
    private PlayerController playerController;

    private Player(List<Skill> skills){
    	this.skills = skills;
    	//mountedState = new Unmounted(getSpeed());
    	
    }

    public static Player playerMakeSmasher(){
    	List<Skill> temp_skills = new ArrayList<Skill>();
    	
    	temp_skills.add(new Skill("one-handed weapon"));
    	temp_skills.add(new Skill("two-handed weapon"));
    	temp_skills.add(new Skill("brawling"));
    	
    	Player player = new Player(temp_skills);
    	
    	return player;
    }

    public static Player playerMakeSneak(){
    	List<Skill> temp_skills = new ArrayList<Skill>();
    	
    	temp_skills.add(new Skill("pick-pocket"));
    	temp_skills.add(new Skill("detect trap"));
    	temp_skills.add(new Skill("remove trap"));
    	temp_skills.add(new Skill("creep"));
    	temp_skills.add(new Skill("rangedWeapon"));
    	
    	Player player = new Player(temp_skills);
    	
    	return player;
    }
    
    public static Player playerMakeSummoner(){
    	List<Skill> temp_skills = new ArrayList<Skill>();
    	
    	temp_skills.add(new Skill("enchantment"));
    	temp_skills.add(new Skill("boon"));
    	temp_skills.add(new Skill("bane"));
    	temp_skills.add(new Skill("staff"));
    	
    	Player player = new Player(temp_skills);
    	
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

    //TODO finish after doing Equipment
    public void attack(){}

    public void useSkill(int skill){}

    public void consumeItem(){}

    public Tool getToolAtIndex(int toolIndex){}

    public void swapState(MountedState mountedState){
    	this.mountedState = mountedState;
    }

    public List<Skill> getSkills(){
        return skills;
    }

    private void addSkillToolToInventory(Tool tool){}
    
    public void setMountHandler(MountHandler mountHandler) {
    	this.mountHandler = mountHandler;
    }
    
}
