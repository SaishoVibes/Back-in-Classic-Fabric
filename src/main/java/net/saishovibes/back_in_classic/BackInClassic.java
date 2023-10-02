package net.saishovibes.back_in_classic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.saishovibes.back_in_classic.registry.BackInClassicBlocks;
import net.saishovibes.back_in_classic.registry.BackInClassicItems;
import net.saishovibes.back_in_classic.events.CauldronBrewing;
import net.saishovibes.back_in_classic.events.NetherReactorIgnition;

import static net.saishovibes.back_in_classic.registry.BackInClassicItems.WAX_BLOCK_ITEM;
public class BackInClassic implements ModInitializer {
    public static final String MODID = "back_in_classic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public static final ItemGroup BACKINCLASSIC_GROUP = FabricItemGroup.builder(id("bic_group")).icon(() -> new ItemStack(WAX_BLOCK_ITEM)).build();

    @Override
    public void onInitialize() {
        BackInClassicBlocks.init();
        BackInClassicItems.init();
        CauldronBrewing.initialize();
        NetherReactorIgnition.activate();
        LOGGER.info("Back in Classic Mod Initialized!");
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }
}