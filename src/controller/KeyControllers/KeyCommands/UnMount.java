package controller.KeyControllers.KeyCommands;

import controller.Handlers.MountHandler;
import model.Entities.MountSate.Unmounted;
import model.Entities.Player;

public class UnMount extends KeyCommand{

    private Player player;
    private MountHandler handler;
    
    public UnMount(Player player, MountHandler handler){
        super("unMount");
        this.player = player;
        this.handler = handler;
    }
    
    @Override
    public void perform() {
       handler.unmount(player);
    }
}
