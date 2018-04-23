package controller.KeyControllers;

import controller.KeyControllers.KeyCommands.KeyCommand;
import javafx.scene.input.KeyCode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KeyBindingMapper {

    String filepath;
    List<String> keyMappings;

    public KeyBindingMapper(String filepath){
        this.filepath = filepath;
        keyMappings = new ArrayList<>();

        Scanner s = null;
        try {
            s = new Scanner(new File(filepath));
            while (s.hasNextLine()){
                keyMappings.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public KeyCode getKeyCodeFor(String name){
        int index = 0;

        /*System.out.println(keyMappings.size());*/

        while (!keyMappings.get(index++).equals(name));

        KeyCode keycode = KeyCode.getKeyCode(keyMappings.get(index));
        System.out.println("name: " + name + " stringsaved: " + keyMappings.get(index) + " keycode loaded: " + keycode.getName());
        return keycode;
    }

    public void saveKeyCode(String name, KeyCode keyCode){
        int index = 0;
        while (!keyMappings.get(index++).equals(name));

        keyMappings.set(index, keyCode.getName());
        try {
            FileWriter file = new FileWriter(filepath);
            BufferedWriter bf = new BufferedWriter(file);

            for(String string : keyMappings){
                bf.write(string + "\n");
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
