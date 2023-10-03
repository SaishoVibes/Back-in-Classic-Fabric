package net.saishovibes.backinclassic.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.saishovibes.backinclassic.BackInClassic;
import net.saishovibes.backinclassic.blocks.PotionCauldronBlock;
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

    Block AWKWARD_CAULDRON = createBlock("awkward_cauldron", PotionCauldronBlock.of(Potions.AWKWARD));
    Block FIRE_RES_CAULDRON = createBlock("fire_cauldron", PotionCauldronBlock.of(Potions.FIRE_RESISTANCE));
    Block HARM_CAULDRON = createBlock("harm_cauldron", PotionCauldronBlock.of(Potions.HARMING));
    Block HEAL_CAULDRON = createBlock("heal_cauldron", PotionCauldronBlock.of(Potions.HEALING));
    Block INVIS_CAULDRON = createBlock("invis_cauldron", PotionCauldronBlock.of(Potions.INVISIBILITY));
    Block JUMP_CAULDRON = createBlock("jump_cauldron", PotionCauldronBlock.of(Potions.LEAPING));
    Block NIGHT_VIS_CAULDRON = createBlock("night_cauldron", PotionCauldronBlock.of(Potions.NIGHT_VISION));
    Block POISON_CAULDRON = createBlock("poison_cauldron", PotionCauldronBlock.of(Potions.POISON));
    Block REGEN_CAULDRON = createBlock("regen_cauldron", PotionCauldronBlock.of(Potions.REGENERATION));
    Block SLOW_CAULDRON = createBlock("slow_cauldron", PotionCauldronBlock.of(Potions.SLOWNESS));
    Block SLOWFALL_CAULDRON = createBlock("slowfall_cauldron", PotionCauldronBlock.of(Potions.SLOW_FALLING));
    Block SPEED_CAULDRON = createBlock("speed_cauldron", PotionCauldronBlock.of(Potions.SWIFTNESS));
    Block STRENGTH_CAULDRON = createBlock("strength_cauldron", PotionCauldronBlock.of(Potions.STRENGTH));
    Block WATER_BREATH_CAULDRON = createBlock("water_breathing_cauldron", PotionCauldronBlock.of(Potions.WATER_BREATHING));
    Block WEAKNESS_CAULDRON = createBlock("weakness_cauldron", PotionCauldronBlock.of(Potions.WEAKNESS));
    Block TURTLE_MASTER_CAULDRON = createBlock("turtle_master_cauldron", PotionCauldronBlock.of(Potions.TURTLE_MASTER));

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