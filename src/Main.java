import controller.LoadGame.GameLoader;
import controller.LoadGame.GameSaver;
import controller.MapControllers.WorldController;

public class Main {

    public static void main(String[] args) {
        GameLoader loader = new GameLoader();
        WorldController theworld = loader.load();
        theworld.runGame();

        GameSaver saver = new GameSaver();
        saver.save(theworld);

    }

}
