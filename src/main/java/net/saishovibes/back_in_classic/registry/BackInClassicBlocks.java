package net.saishovibes.back_in_classic.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.saishovibes.back_in_classic.BackInClassic;
import net.minecraft.registry.Registry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public interface BackInClassicBlocks {
    Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    Block WAX_BLOCK = createBlock("wax_block", new SlimeBlock(FabricBlockSettings.copyOf(Blocks.HONEYCOMB_BLOCK)));
    Block CLASSIC_NETHER_PORTAL = createBlock("classic_nether_portal", new Block(FabricBlockSettings.copyOf(Blocks.HONEYCOMB_BLOCK).luminance(9)));
    Block COGWHEEL = createBlock("cogwheel", new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_BLOCK)));
    Block DIRT_SLAB = createBlock("dirt_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.DIRT).nonOpaque()));
    Block GEAR = createBlock("gear", new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_WIRE).nonOpaque()));
    Block GLOWING_OBSIDIAN = createBlock("glowing_obsidian", new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).luminance(10)));
    Block INF_LAVA = createBlock("infinite_lava", new Block(FabricBlockSettings.copyOf(Blocks.LAVA).nonOpaque()));
    Block INF_WATER = createBlock("infinite_water", new Block(FabricBlockSettings.copyOf(Blocks.WATER).nonOpaque()));
    Block REV_GEAR = createBlock("inverse_gear", new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_WIRE).nonOpaque()));
    Block NETHER_REACTOR = createBlock("nether_reactor_core", new Block(FabricBlockSettings.copyOf(Blocks.GLOWSTONE).luminance(12)));
    Block SOD_BLOCK = createBlock("sod_block", new Block(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK)));
    Block SOD_SLAB = createBlock("sod_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK).nonOpaque()));
    Block CRUSHED_GRAVEL = createBlock("crushed_gravel", new FallingBlock(FabricBlockSettings.copyOf(Blocks.GRAVEL)));

    Block BLUE_ROSE = createBlock("blue_rose", new PlantBlock(FabricBlockSettings.copyOf(Blocks.BLUE_ORCHID).nonOpaque()));
    Block PAEONIA = createBlock("paeonia_flower", new PlantBlock(FabricBlockSettings.copyOf(Blocks.PINK_TULIP).nonOpaque()));
    Block RED_ROSE = createBlock("red_rose", new PlantBlock(FabricBlockSettings.copyOf(Blocks.POPPY).nonOpaque()));
    Block SHRUB = createBlock("shrub", new PlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH).nonOpaque()));

    Block AWKWARD_CAULDRON = createBlock("awkward_cauldron", new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).nonOpaque().requiresTool()));
    Block FIRE_RES_CAULDRON = createBlock("fire_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block HARM_CAULDRON = createBlock("harm_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block HEAL_CAULDRON = createBlock("heal_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block INVIS_CAULDRON = createBlock("invis_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block JUMP_CAULDRON = createBlock("jump_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block NIGHT_VIS_CAULDRON = createBlock("night_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block POISON_CAULDRON = createBlock("poison_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block REGEN_CAULDRON = createBlock("regen_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block SLOW_CAULDRON = createBlock("slow_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block SLOWFALL_CAULDRON = createBlock("slowfall_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block SPEED_CAULDRON = createBlock("speed_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block STRENGTH_CAULDRON = createBlock("strength_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block WATER_BREATH_CAULDRON = createBlock("water_breathing_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block WEAKNESS_CAULDRON = createBlock("weakness_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block TURTLE_MASTER_CAULDRON = createBlock("turtle_master_cauldron", new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));

    static Block createBlock(String name, Block block) {
        return createBlock(name, block, new BlockItem(block, new FabricItemSettings()));
    }

    static Block createBlock(String name, Block block, @Nullable BlockItem blockItem) {
        BLOCKS.put(BackInClassic.id(name), block);
        if (blockItem != null) BackInClassicItems.createItem(name, blockItem);
        return block;
    }

    static void init() {
        BLOCKS.forEach((id, entry) -> Registry.register(Registries.BLOCK, id, entry));
    }
}