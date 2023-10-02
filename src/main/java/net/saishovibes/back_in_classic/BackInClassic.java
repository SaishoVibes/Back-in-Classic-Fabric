package net.saishovibes.back_in_classic;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.saishovibes.back_in_classic.events.CauldronBrewing;
import net.saishovibes.back_in_classic.events.NetherReactorIgnition;
import net.saishovibes.back_in_classic.registry.BackInClassicBlocks;
import net.saishovibes.back_in_classic.registry.BackInClassicItems;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackInClassic implements ModInitializer {
    public static final String MODID = "back_in_classic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        BackInClassicBlocks.init();
        BackInClassicItems.init();
        CauldronBrewing.initialize();
        NetherReactorIgnition.activate();
        LOGGER.info("Back in Classic Mod Initialized!");
    }

    public static @NotNull Identifier id(String name) {
        return new Identifier(MODID, name);
    }
}