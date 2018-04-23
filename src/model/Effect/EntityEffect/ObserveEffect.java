package model.Effect.EntityEffect;

import controller.LoadGame.SaveVisitor;
import model.Entities.Entity;
import view.UpdateEntityRelatedView;

public class ObserveEffect implements EntityEffect {
    private String name;
    private int amount;
    private UpdateEntityRelatedView updateEntityRelatedView;
    private ObserveObserver observeObserver;
    public ObserveEffect(int amount) {
        this.amount = amount;
    }

    public ObserveEffect(int amount, ObserveObserver observeObserver) {
        this.amount = amount;
        this.observeObserver = observeObserver;
    }

    @Override
    public void apply(Entity entity) {
        observeObserver.update(entity);
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
