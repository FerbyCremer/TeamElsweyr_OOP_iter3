package controller.LoadGame;

public interface Saveable {

    String accept(SaveVisitor saveVisitor);
}
