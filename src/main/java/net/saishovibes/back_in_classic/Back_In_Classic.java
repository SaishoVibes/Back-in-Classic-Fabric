package net.saishovibes.back_in_classic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.saishovibes.back_in_classic.registry.back_in_classic_blocks;
import net.saishovibes.back_in_classic.registry.back_in_classic_items;
import net.saishovibes.back_in_classic.block.wax_block;

import static net.saishovibes.back_in_classic.registry.back_in_classic_items.WAX_BLOCK_ITEM;
public class Back_In_Classic implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("back_in_classic");
    public static final String MODID = "back_in_classic";
    public static final ItemGroup BACKINCLASSIC_GROUP = FabricItemGroup.builder(new Identifier(MODID, "bic_group")).icon(() -> new ItemStack(WAX_BLOCK_ITEM)).build();
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        back_in_classic_blocks.init();
        back_in_classic_items.init();
        LOGGER.info("Back in Classic Mod Initialized!");
    }
}



