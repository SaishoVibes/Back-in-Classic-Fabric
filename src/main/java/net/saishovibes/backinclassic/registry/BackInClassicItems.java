package net.saishovibes.backinclassic.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.saishovibes.backinclassic.BackInClassic;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public interface BackInClassicItems {
    Map<Identifier, Item> ITEMS = new LinkedHashMap<>();
    ItemGroup BACKINCLASSIC_GROUP = FabricItemGroup.builder(BackInClassic.id("bic_group")).icon(() -> new ItemStack(BackInClassicBlocks.WAX_BLOCK.asItem())).build();

    static void init() {
        ITEMS.forEach((id, item) -> {
            Registry.register(Registries.ITEM, id, item);
            ItemGroupEvents.modifyEntriesEvent(BACKINCLASSIC_GROUP).register(content -> content.add(item));
        });
    }

    @SuppressWarnings("UnusedReturnValue")
    static <T extends Item> T createItem(String name, T item) {
        ITEMS.put(BackInClassic.id(name), item);
        return item;
    }
}