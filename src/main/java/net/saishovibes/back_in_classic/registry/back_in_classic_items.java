package net.saishovibes.back_in_classic.registry;

import net.saishovibes.back_in_classic.Back_In_Classic;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.saishovibes.back_in_classic.registry.back_in_classic_blocks.*;

@SuppressWarnings("unused")
public interface back_in_classic_items {
    Map<Identifier, Item> ITEMS = new LinkedHashMap<>();
    Item WAX_BLOCK_ITEM = register(new Identifier(Back_In_Classic.MODID, "wax_block"), new BlockItem(WAX_BLOCK, new FabricItemSettings()));

    //ItemGroupEvents.ModifyEntries(BACKINCLASSIC_GROUP).register(content -> {content.add(WAX_BLOCK_ITEM);});
    static <T extends Item> T register(Identifier id, T entry) {
        ITEMS.put(id, entry);
        return entry;
    }

    static void init() {
        ITEMS.forEach((id, entry) -> Registry.register(Registries.ITEM, id, entry));
    }
}
