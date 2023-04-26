package net.saishovibes.back_in_classic.registry;

import net.saishovibes.back_in_classic.Back_In_Classic;
import net.minecraft.registry.Registry;
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

    //BLOCKS
    Block WAX_BLOCK = register(new Identifier(Back_In_Classic.MODID, "wax_block"), new SlimeBlock(FabricBlockSettings.copyOf(Blocks.HONEYCOMB_BLOCK)));
    Block CLASSIC_NETHER_PORTAL = register(new Identifier(Back_In_Classic.MODID, "classic_nether_portal"), new Block(FabricBlockSettings.copyOf(Blocks.HONEYCOMB_BLOCK).luminance(9)));
    Block COGWHEEL = register(new Identifier(Back_In_Classic.MODID, "cogwheel"), new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_BLOCK)));
    Block DIRT_SLAB = register(new Identifier(Back_In_Classic.MODID, "dirt_slab"), new SlabBlock(FabricBlockSettings.copyOf(Blocks.PETRIFIED_OAK_SLAB).nonOpaque()));
    Block GEAR = register(new Identifier(Back_In_Classic.MODID, "gear"), new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_WIRE).nonOpaque()));
    Block GLOWING_OBSIDIAN = register(new Identifier(Back_In_Classic.MODID, "glowing_obsidian"), new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).luminance(10)));
    Block INF_LAVA = register(new Identifier(Back_In_Classic.MODID, "infinite_lava"), new Block(FabricBlockSettings.copyOf(Blocks.LAVA).nonOpaque()));
    Block INF_WATER = register(new Identifier(Back_In_Classic.MODID, "infinite_water"), new Block(FabricBlockSettings.copyOf(Blocks.WATER).nonOpaque()));
    Block REV_GEAR = register(new Identifier(Back_In_Classic.MODID, "inverse_gear"), new Block(FabricBlockSettings.copyOf(Blocks.REDSTONE_WIRE).nonOpaque()));
    Block NETHER_REACTOR = register(new Identifier(Back_In_Classic.MODID, "nether_reactor_core"), new Block(FabricBlockSettings.copyOf(Blocks.GLOWSTONE).luminance(12)));
    Block SOD_BLOCK = register(new Identifier(Back_In_Classic.MODID, "sod_block"), new Block(FabricBlockSettings.copyOf(Blocks.MOSS_BLOCK)));
    Block SOD_SLAB = register(new Identifier(Back_In_Classic.MODID, "sod_slab"), new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB).nonOpaque()));
    Block CRUSHED_GRAVEL = register(new Identifier(Back_In_Classic.MODID, "crushed_gravel"), new FallingBlock(FabricBlockSettings.copyOf(Blocks.GRAVEL)));

    //PLANTS
    Block BLUE_ROSE = register(new Identifier(Back_In_Classic.MODID, "blue_rose"), new PlantBlock(FabricBlockSettings.copyOf(Blocks.BLUE_ORCHID).nonOpaque()));
    Block PAEONIA = register(new Identifier(Back_In_Classic.MODID, "paeonia_flower"), new PlantBlock(FabricBlockSettings.copyOf(Blocks.PINK_TULIP).nonOpaque()));
    Block RED_ROSE = register(new Identifier(Back_In_Classic.MODID, "red_rose"), new PlantBlock(FabricBlockSettings.copyOf(Blocks.POPPY).nonOpaque()));
    Block SHRUB = register(new Identifier(Back_In_Classic.MODID, "shrub"), new PlantBlock(FabricBlockSettings.copyOf(Blocks.DEAD_BUSH).nonOpaque()));

    //CAULDRONS
    Block AWKWARD_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "awkward_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block FIRE_RES_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "fire_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block HARM_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "harm_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block HEAL_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "heal_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block INVIS_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "invis_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block JUMP_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "jump_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block NIGHT_VIS_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "night_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block POISON_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "poison_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block REGEN_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "regen_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block SLOW_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "slow_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block SLOWFALL_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "slowfall_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block SPEED_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "speed_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block STRENGTH_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "strength_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block WATER_BREATH_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "water_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block WEAKNESS_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "weakness_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));
    Block TURTLE_MASTER_CAULDRON = register(new Identifier(Back_In_Classic.MODID, "turtle_master_cauldron"), new Block(FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque()));

    static <T extends Block> T register(Identifier id, T entry) {
        BLOCKS.put(id, entry);
        return entry;
    }

    static void init() {
        BLOCKS.forEach((id, entry) -> Registry.register(Registries.BLOCK, id, entry));
    }
}
