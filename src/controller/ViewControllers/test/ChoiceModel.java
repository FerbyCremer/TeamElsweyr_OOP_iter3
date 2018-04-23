package controller.ViewControllers.test;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Parent;

public class ChoiceModel extends Parent
{
    private final StringProperty label;
    private final BooleanProperty isSelected;

    public ChoiceModel()
    {
        this(null, false);
    }

    public ChoiceModel(String label)
    {
        this(label, false);
    }

    public ChoiceModel(String label, boolean isSelected)
    {
        this.label = new SimpleStringProperty(label);
        this.isSelected = new SimpleBooleanProperty(isSelected);
    }

    public String getLabel(){ return label.get(); }
    public void setLabel(String label){ this.label.set(label); }
    public StringProperty labelProperty(){ return label; }

    public boolean isSelected(){ return isSelected.get(); }
    public void setSelected(boolean isSelected){ this.isSelected.set(isSelected); }
    public BooleanProperty isSelectedProperty(){ return isSelected; }
}