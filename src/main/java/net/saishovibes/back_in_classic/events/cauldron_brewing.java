package net.saishovibes.back_in_classic.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface cauldron_brewing {
    Event<cauldron_brewing> EVENT = EventFactory.createArrayBacked(cauldron_brewing.class, (listeners) -> (player, block) -> {
        for (cauldron_brewing listener : listeners) {
            ActionResult result = listener.interact(player, block);

            if(result != ActionResult.PASS) {
                return result;
            }
        }
        return ActionResult.PASS;
    });
    ActionResult interact(PlayerEntity player, Block block);
}
