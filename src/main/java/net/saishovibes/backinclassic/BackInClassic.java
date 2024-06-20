package net.saishovibes.backinclassic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.util.Identifier;
import net.saishovibes.backinclassic.events.CauldronBrewing;
import net.saishovibes.backinclassic.events.NetherReactorIgnition;
import net.saishovibes.backinclassic.registry.BackInClassicBlocks;
import net.saishovibes.backinclassic.registry.BackInClassicItems;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackInClassic implements ModInitializer {
    public static final String MODID = "back_in_classic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        BackInClassicBlocks.init();
        BackInClassicItems.RegisterItemGroups();
        UseBlockCallback.EVENT.register(CauldronBrewing::interact);
        UseBlockCallback.EVENT.register(NetherReactorIgnition::interact);
        LOGGER.info("Back in Classic Mod Initialized!");
    }

    public static @NotNull Identifier id(String name) {
        return new Identifier(MODID, name);
    }
}