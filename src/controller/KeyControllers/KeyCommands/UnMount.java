package controller.KeyControllers.KeyCommands;

import model.Entities.Player;

public class UnMount implements KeyCommand{

    private Player player;
    public UnMount(Player player){
        this.player = player;
    }
    @Override
    public void perform() {
       //player.swapState(new U);
    }
}
