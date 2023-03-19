package net.saishovibes.back_in_classic.registry;

import net.saishovibes.back_in_classic.Back_In_Classic;
import net.minecraft.registry.Registry;
//import saishovibes.back_in_classic.back_in_classic;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;
import net.minecraft.registry.Registries;
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public interface back_in_classic_blocks {
    Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();
    Block WAX_BLOCK = register(new Identifier(Back_In_Classic.MODID, "wax_block"), new Block(FabricBlockSettings.copyOf(Blocks.HONEYCOMB_BLOCK).nonOpaque()));

    static <T extends Block> T register(Identifier id, T entry) {
        BLOCKS.put(id, entry);
        return entry;
    }

    static void init() {
        BLOCKS.forEach((id, entry) -> Registry.register(Registries.BLOCK, id, entry));
    }
}
