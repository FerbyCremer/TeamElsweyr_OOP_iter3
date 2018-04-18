package model.Entities;

public interface EntityVisitable {

    void accept(EntityVisitor entityVisitor);
}
