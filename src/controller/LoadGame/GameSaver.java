package controller.LoadGame;

import controller.MapControllers.WorldController;
import model.Map.World;

import java.io.FileWriter;
import java.io.IOException;

public class GameSaver {

    SaveVisitor saver;

    public GameSaver(){
        saver = new GameSaveVisitor();
    }

    public void save(WorldController worldController) {
        String savefile = "";

        savefile += worldController.getWorld().accept(saver);

        System.out.println(savefile);
        try {
            FileWriter fw = new FileWriter("src/assets/saves/jadsSave.txt");
            fw.write(savefile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
