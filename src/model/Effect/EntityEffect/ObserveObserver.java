package model.Effect.EntityEffect;

import model.Entities.Entity;
import model.Map.Zone.Zone;

import java.awt.*;

public class ObserveObserver {

    Entity entity;
    Zone zone;
    int cooldown = 0;
    public ObserveObserver(Zone zone){
        this.zone = zone;
    }

    public void update(Entity entity){
        cooldown = 60;
        this.entity = entity;
    }

    public boolean hasText(){//could be inverse
        cooldown--;
        if(cooldown < 0){
            cooldown = 0;
            return false;
        }
        return true;
    }

    public Point getPoint(){
        return zone.getEntityMap().getTileOf(entity).getCoordinate();
    }

    public String getText(){
        return ""+entity.getHealth();
    }
}
