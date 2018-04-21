package model.Entities;

public class Pet extends Entity {

    private Player owner;

    public Pet(Player player){
        owner = player;
    }
}
