package model.Entities;

import controller.LoadGame.SaveVisitor;
import controller.LoadGame.Saveable;

public class Skill
{
	private String name;
	private int level;
	
	public Skill(String name) {
		this.name = name;
		level = 1;
	}
	
	//loading constructor
	public Skill(String name, int level) {
		this.name = name;
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void increaseLevel() {
		++level;
	}
	
	public double getModifier() {
		return (double) level*0.04;
	}
	
	public boolean equals(Object otherSkill) {
		boolean equal = otherSkill instanceof Skill;
		
		if(!equal) 
			return false;
		
		Skill temp = (Skill)otherSkill;
		
		return name.equals(temp.getName());
	}
	
	public String getName() {
		return name;
	}
}
