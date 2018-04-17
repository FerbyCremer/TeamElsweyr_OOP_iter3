package model.Entities;

import controller.EntityControllers.PlayerController;
import controller.Handlers.MountHandler;
import model.Entities.MountSate.MountedState;
import model.Items.Takeable.Tool;

import java.util.List;

public class Player {
    private List<Skill> skills;
    private MountedState mountedState;
    private MountHandler mountHandler;
    private PlayerController playerController;

    private Player(List<Skill> skills){

    }

    public static void playerMakeSmasher(){}
    public static void playerMakeSneak(){}
    public static void playerMakeSummoner(){}

    public double getModifier(Skill skill){}

    public void setState(MountedState mountedState){}

    public void attack(){}

    public void useSkill(int skill){}

    public void consumeItem(){}

    public Tool getToolAtIndex(int toolIndex){}

    public void swapState(MountedState mountedState){}

    public List<Skill> getSkills(){
        return skills;
    }

    private void addSkillToolToInventory(Tool tool){}




}
