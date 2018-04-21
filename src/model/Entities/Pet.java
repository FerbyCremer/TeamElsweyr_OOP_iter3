package model.Entities;

import controller.Handlers.BringOutYourDeadHandler;

public class Pet extends Entity {

    private Player owner;

    public Pet(Player player, EntityStats stats, BringOutYourDeadHandler deadHandler){
    	super(stats, deadHandler);
        owner = player;
    }
}
