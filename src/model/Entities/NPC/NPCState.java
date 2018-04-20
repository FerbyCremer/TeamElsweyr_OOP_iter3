package model.Entities.NPC;

import controller.EntityControllers.AIController;
import model.Entities.Player;

public interface NPCState {
    void move(AIController aiController, NPC npc);
    void performInteraction(NPC npc, Player player);
}
