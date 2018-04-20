package controller.KeyControllers.KeyCommands;

import controller.KeyControllers.KeyCommands.KeyCommand;
import model.Entities.Player;
import model.Items.Takeable.Tool;


public class UseTool implements KeyCommand {
    private Player player;
    private Tool tool;

    //Paramterize with the relevant skill tool.
    public UseTool(Player player, Tool tool){
        this.player = player;
        this.tool = tool;
    }
    @Override
    public void perform() {
        tool.use(player);
    }
}
