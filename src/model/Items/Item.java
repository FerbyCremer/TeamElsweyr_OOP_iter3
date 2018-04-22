package model.Items;


import controller.LoadGame.Saveable;
import model.Entities.Entity;

public abstract class Item implements Saveable{
    private String name;

    public abstract void touchedBy(Entity entity);

    public String getName() {
        return name;
    }

	public void setName(String name) {
		this.name = name;
	}
}
