package net.saishovibes.backinclassic.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.saishovibes.backinclassic.BackInClassic;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin.register;

@SuppressWarnings("unused")
public class BackInClassicItems {
    static Map<Identifier, Item> ITEMS = new LinkedHashMap<>();
    public static RegistryKey<ItemGroup> BACKINCLASSIC_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(BackInClassic.MODID, "backinclassic"));


    /*static void init() {
        ITEMS.forEach((id, item) -> {
            Registry.register(Registries.ITEM, id, item);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.add(item));
        });
    }*/
    public static void RegisterItemGroups() {
        /*ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> {
            entries.add(BackInClassicBlocks.INF_WATER);
            entries.add(BackInClassicBlocks.INF_LAVA);
            entries.add(BackInClassicBlocks.AWKWARD_CAULDRON);
            entries.add(BackInClassicBlocks.FIRE_RES_CAULDRON);
            entries.add(BackInClassicBlocks.HARM_CAULDRON);
            entries.add(BackInClassicBlocks.HEAL_CAULDRON);
            entries.add(BackInClassicBlocks.INVIS_CAULDRON);
            entries.add(BackInClassicBlocks.JUMP_CAULDRON);
            entries.add(BackInClassicBlocks.POISON_CAULDRON);
            entries.add(BackInClassicBlocks.NIGHT_VIS_CAULDRON);
            entries.add(BackInClassicBlocks.REGEN_CAULDRON);
            entries.add(BackInClassicBlocks.SLOWFALL_CAULDRON);
            entries.add(BackInClassicBlocks.SLOW_CAULDRON);
            entries.add(BackInClassicBlocks.SPEED_CAULDRON);
            entries.add(BackInClassicBlocks.STRENGTH_CAULDRON);
            entries.add(BackInClassicBlocks.TURTLE_MASTER_CAULDRON);
            entries.add(BackInClassicBlocks.WATER_BREATH_CAULDRON);
            entries.add(BackInClassicBlocks.WEAKNESS_CAULDRON);
        });*/
        Registry.register(Registries.ITEM_GROUP, BACKINCLASSIC_GROUP, FabricItemGroup.builder().displayName(Text.translatable("back_in_classic.itemgroup")).icon(() -> new ItemStack(BackInClassicBlocks.WAX_BLOCK.asItem())).entries((displayContext, entries) -> {
            entries.add(BackInClassicBlocks.WAX_BLOCK);
            entries.add(BackInClassicBlocks.SOD_BLOCK);
            entries.add(BackInClassicBlocks.SOD_SLAB);
            entries.add(BackInClassicBlocks.DIRT_SLAB);
            entries.add(BackInClassicBlocks.CRUSHED_GRAVEL);
            entries.add(BackInClassicBlocks.GLOWING_OBSIDIAN);
            entries.add(BackInClassicBlocks.RED_ROSE);
            entries.add(BackInClassicBlocks.BLUE_ROSE);
            entries.add(BackInClassicBlocks.PAEONIA);
            entries.add(BackInClassicBlocks.SHRUB);
            entries.add(BackInClassicBlocks.NETHER_REACTOR);
            entries.add(BackInClassicBlocks.COGWHEEL);
            entries.add(BackInClassicBlocks.PETRIFIED_OAK_LOG);
            entries.add(BackInClassicBlocks.PETRIFIED_OAK_WOOD);
            entries.add(BackInClassicBlocks.PETRIFIED_OAK_PLANKS);
            entries.add(BackInClassicBlocks.PETRIFIED_OAK_STAIRS);

        }).build());
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