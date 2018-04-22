import controller.LoadGame.GameLoader;
import controller.MapControllers.WorldController;

public class Main {

    public static void main(String[] args) {
        GameLoader loader = new GameLoader();
        WorldController theworld = loader.load();
        theworld.runGame();

    }

}
