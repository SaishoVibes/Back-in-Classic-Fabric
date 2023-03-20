package net.saishovibes.back_in_classic.block;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;

import static net.saishovibes.back_in_classic.Back_In_Classic.MODID;
import net.saishovibes.back_in_classic.registry.back_in_classic_items;
import net.saishovibes.back_in_classic.registry.back_in_classic_items;
public class wax_block implements ModInitializer {
    public static final Block WAX_BLOCK = new Block(FabricBlockSettings.of(Material.FROGLIGHT).strength(4.0f).breakInstantly());

    @Override
    public void onInitialize() {
        Registry.register(Registries.BLOCK, new Identifier(MODID, "wax_block"), WAX_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(MODID, "wax_block"), new BlockItem(WAX_BLOCK, new FabricItemSettings()));
    }
}