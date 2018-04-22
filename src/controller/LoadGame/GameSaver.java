package controller.LoadGame;

import controller.MapControllers.WorldController;
import model.Map.World;

import java.io.BufferedWriter;
import java.io.File;
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
            FileWriter file = new FileWriter("src/assets/saves/jadsSave.txt");
            BufferedWriter bf = new BufferedWriter(file);
            bf.write(savefile);
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
