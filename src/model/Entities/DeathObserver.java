package model.Entities;

import model.Updateable;

public class DeathObserver implements Updateable {
    private Entity entity;
    //private DeathView deathView;
    public DeathObserver(){}

    public DeathObserver(Entity entity){
        this.entity = entity;
    }

    public void setEntity(Entity entity){
        this.entity = entity;
    }

    @Override
    public void update() {
        if(entity.getHealth() <= 0);
    }
}
