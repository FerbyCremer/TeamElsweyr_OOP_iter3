package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class UnMount extends KeyCommand{

    private Player player;
    
    public UnMount(Player player){
        super("");
        this.player = player;
    }
    
    @Override
    public void perform() {
       player.Unmount();
    }
}
