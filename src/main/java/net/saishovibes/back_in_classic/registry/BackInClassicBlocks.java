package net.saishovibes.back_in_classic.registry;

import net.saishovibes.back_in_classic.BackInClassic;
import net.minecraft.registry.Registry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;
import net.minecraft.registry.Registries;
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public interface BackInClassicBlocks {
    Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    //BLOCKS
    Block WAX_BLOCK = register(BackInClassic.id("wax_block"), new SlimeBlock(FabricBlockSettings.copyOf(Blocks.HONEYCOMB_BLOCK)));
    Block CLASSIC_NETHER_PORTAL = register(BackInClassic.id("classic_nether_portal"), new Block(FabricBlockSettings.copyOf(Blocks.HONEYCOMB_BLOCK).luminance(9)));
    Block COGWHEEL = register(BackInClassic.id("cogwheel"), new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_BLOCK)));
    Block DIRT_SLAB = register(BackInClassic.id("dirt_slab"), new SlabBlock(FabricBlockSettings.copyOf(Blocks.DIRT).nonOpaque()));
    Block GEAR = register(BackInClassic.id("gear"), new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_WIRE).nonOpaque()));
    Block GLOWING_OBSIDIAN = register(BackInClassic.id("glowing_obsidian"), new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).luminance(10)));
    Block INF_LAVA = register(BackInClassic.id("infinite_lava"), new Block(FabricBlockSettings.copyOf(Blocks.LAVA).nonOpaque()));
    Block INF_WATER = register(BackInClassic.id("infinite_water"), new Block(FabricBlockSettings.copyOf(Blocks.WATER).nonOpaque()));
    Block REV_GEAR = register(BackInClassic.id("inverse_gear"), new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_WIRE).nonOpaque()));
    Block NETHER_REACTOR = register(BackInClassic.id("nether_reactor_core"), new Block(FabricBlockSettings.copyOf(Blocks.GLOWSTONE).luminance(12)));
    Block SOD_BLOCK = register(BackInClassic.id("sod_block"), new Block(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK)));
    Block SOD_SLAB = register(BackInClassic.id("sod_slab"), new SlabBlock(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK).nonOpaque()));
    Block CRUSHED_GRAVEL = register(BackInClassic.id("crushed_gravel"), new FallingBlock(FabricBlockSettings.copyOf(Blocks.GRAVEL)));

    //PLANTS
    Block BLUE_ROSE = register(BackInClassic.id("blue_rose"), new PlantBlock(FabricBlockSettings.copyOf(Blocks.BLUE_ORCHID).nonOpaque()));
    Block PAEONIA = register(BackInClassic.id("paeonia_flower"), new PlantBlock(FabricBlockSettings.copyOf(Blocks.PINK_TULIP).nonOpaque()));
    Block RED_ROSE = register(BackInClassic.id("red_rose"), new PlantBlock(FabricBlockSettings.copyOf(Blocks.POPPY).nonOpaque()));
    Block SHRUB = register(BackInClassic.id("shrub"), new PlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH).nonOpaque()));

    //CAULDRONS
    Block AWKWARD_CAULDRON = register(BackInClassic.id("awkward_cauldron"), new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).nonOpaque().requiresTool()));
    Block FIRE_RES_CAULDRON = register(BackInClassic.id("fire_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block HARM_CAULDRON = register(BackInClassic.id("harm_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block HEAL_CAULDRON = register(BackInClassic.id("heal_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block INVIS_CAULDRON = register(BackInClassic.id("invis_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block JUMP_CAULDRON = register(BackInClassic.id("jump_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block NIGHT_VIS_CAULDRON = register(BackInClassic.id("night_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block POISON_CAULDRON = register(BackInClassic.id("poison_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block REGEN_CAULDRON = register(BackInClassic.id("regen_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block SLOW_CAULDRON = register(BackInClassic.id("slow_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block SLOWFALL_CAULDRON = register(BackInClassic.id("slowfall_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block SPEED_CAULDRON = register(BackInClassic.id("speed_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block STRENGTH_CAULDRON = register(BackInClassic.id("strength_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block WATER_BREATH_CAULDRON = register(BackInClassic.id("water_breathing_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block WEAKNESS_CAULDRON = register(BackInClassic.id("weakness_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block TURTLE_MASTER_CAULDRON = register(BackInClassic.id("turtle_master_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));

    static <T extends Block> T register(Identifier id, T entry) {
        BLOCKS.put(id, entry);
        return entry;
    }

    static void init() {
        BLOCKS.forEach((id, entry) -> Registry.register(Registries.BLOCK, id, entry));
    }
}
