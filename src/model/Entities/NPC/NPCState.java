package model.Entities.NPC;

import controller.EntityControllers.AIController;
import controller.LoadGame.Saveable;
import model.Entities.Player;

public interface NPCState extends Saveable {
    void move(AIController aiController, NPC npc);
    void performInteraction(NPC npc, Player player);
}
