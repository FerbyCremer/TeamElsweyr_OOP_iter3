package model.Effect.EntityEffect;

import model.Entities.Entity;
import view.UpdateEntityRelatedView;

public class ObserveEffect implements EntityEffect {
    private String name;
    private int amount;
    private UpdateEntityRelatedView updateEntityRelatedView;

    public ObserveEffect(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(Entity entity) {
        updateEntityRelatedView.update(entity);
    }

    @Override
    public String getName() {
        return name;
    }
}
