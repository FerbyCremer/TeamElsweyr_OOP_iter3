package controller.ViewControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import model.Entities.Entity;
import model.Updateable;

import java.net.URL;
import java.util.ResourceBundle;

public class StatsController implements Initializable, Updateable {
    @FXML protected double exp = 0.00;
    private Entity entity;
    protected int lvl = 1;
    @FXML ProgressBar health;
    @FXML ProgressBar experience;
    public void initialize(URL url, ResourceBundle bundle) {
        health.setProgress(100.0);
        experience.setProgress(0.0);
    }

    public void decreasehealth(double hp) {

    }

    public void increasehealth(double hp){

    }

    public void gainExp(double exp){

    }

    @Override
    public void update() {
        lvl = entity.getLevel();
        exp = entity.getExp();

    }
}
