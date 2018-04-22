package model.Entities;

import controller.Handlers.BringOutYourDeadHandler;
import controller.LoadGame.SaveVisitor;

public class Pet extends Entity {

    private Player owner;

    public Pet(Player player, EntityStats stats, BringOutYourDeadHandler deadHandler){
    	super(stats, deadHandler);
        owner = player;
    }

    @Override
    public String accept(SaveVisitor saveVisitor){
        return saveVisitor.savePet(this);
    }
}
