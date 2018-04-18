package model.Items;


import model.Entities.Entity;

public abstract class Item {
    private String name;

    public abstract void touchedBy(Entity entity);

}
