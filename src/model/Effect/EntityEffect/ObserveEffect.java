package model.Effect.EntityEffect;

import controller.LoadGame.SaveVisitor;
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
        return "observeEffect";
    }

    @Override
    public String getAmount() {
        return "" + amount;
    }

    @Override
    public String accept(SaveVisitor saveVisitor) {
        return getName()+"\n"+getAmount()+"\n";
    }
}
