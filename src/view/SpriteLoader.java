package view;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SpriteLoader {


    private HashMap<String, Integer> imageHashMap;
    private ArrayList<Image> imageArrayList;
    private ArrayList<File> fileList;
    private String workingDirectory = "file:" + System.getProperty("user.dir");

    SpriteLoader(){
        imageHashMap = new HashMap<>();
        imageArrayList = new ArrayList<>();
        fileList = new ArrayList<>();
        loadImages(workingDirectory + "/src/assets/", fileList);
    }

    private void loadImages(String directoryName, ArrayList<File> files) {
        imageArrayList.add(new Image (workingDirectory + "/src/assets/bow.png"));
        imageHashMap.put("bow", 0);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/brassKnuckles.png"));
        imageHashMap.put("brassKnuckles", 1);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/claws.png"));
        imageHashMap.put("claws", 2);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/club.png"));
        imageHashMap.put("club", 3);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/crossbow.png"));
        imageHashMap.put("crossbow", 4);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/dagger.png"));
        imageHashMap.put("dagger", 5);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/fists.png"));
        imageHashMap.put("fists", 6);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/fog.png"));
        imageHashMap.put("fog", 7);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/forest.png"));
        imageHashMap.put("forest", 8);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/grass.png"));
        imageHashMap.put("grass", 9);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/longbow.png"));
        imageHashMap.put("longbow", 10);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/metalCane.png"));
        imageHashMap.put("metalCane", 11);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/mountain.png"));
        imageHashMap.put("mountain", 12);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/nonVisible.png"));
        imageHashMap.put("nonVisible", 13);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/plateau.png"));
        imageHashMap.put("plateau", 14);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/potion.png"));
        imageHashMap.put("potion", 15);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/river.png"));
        imageHashMap.put("river", 16);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/stick.png"));
        imageHashMap.put("stick", 17);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/sword.png"));
        imageHashMap.put("sword", 18);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/twoHandedAxe.png"));
        imageHashMap.put("twoHandedAxe", 19);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/twoHandedClub.png"));
        imageHashMap.put("twoHandedClub", 20);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/twoHandedSword.png"));
        imageHashMap.put("twoHandedSword", 21);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/volcano.png"));
        imageHashMap.put("volcano", 22);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/woodenCane.png"));
        imageHashMap.put("woodenCane", 23);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/twoHandedSword.png"));
        imageHashMap.put("twoHandedSword", 24);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/twoHandedSword.png"));
        imageHashMap.put("twoHandedSword", 25);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/twoHandedSword.png"));
        imageHashMap.put("twoHandedSword", 26);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/5i.png"));
        imageHashMap.put("5i", 27);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/potion.png"));
        imageHashMap.put("healEffect", 28);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/volcano.png"));
        imageHashMap.put("damageEffect", 29);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/blueScroll.png"));
        imageHashMap.put("expEffect", 30);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/volcano.png"));
        imageHashMap.put("deathEffect", 31);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/river.png"));
        imageHashMap.put("water", 32);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/mount.png"));
        imageHashMap.put("mount", 33);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/1i.png"));
        imageHashMap.put("1i", 34);
        imageArrayList.add(new Image (workingDirectory + "/src/assets/explosion.png"));
        imageHashMap.put("explosion", 35);
    }

    public Image getImage(String s){
        return imageArrayList.get(imageHashMap.get(s));
    }


}
