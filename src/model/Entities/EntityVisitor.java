package model.Entities;

public interface EntityVisitor {

    void visit(Entity entity);
    void visit(Mount mount);
    void visit(Player player);
}
