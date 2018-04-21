package model.Entities;

public class Skill {
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
	
	public void increaseLevel() {
		++level;
	}
	
	public double getModifier() {
		return Math.log((double) level);
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
