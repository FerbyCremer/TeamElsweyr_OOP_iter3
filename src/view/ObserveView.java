package view;

import model.Entities.Entity;

public class ObserveView implements UpdateEntityRelatedView {

    private String entityName;
    private int entityHealth;
    private int entityLevel;
    public ObserveView(){}

    @Override
    public void update(Entity... entities) {
        entityName = entities[0].getName();
        entityHealth = entities[0].getHealth();
        entityLevel = entities[0].getLevel();
    }
}
