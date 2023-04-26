package net.saishovibes.back_in_classic.registry;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

import net.saishovibes.back_in_classic.Back_In_Classic;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
//import net.saishovibes.back_in_classic.item.PlateArmorMaterial;
//temp 3845946

import java.util.LinkedHashMap;
import java.util.Map;
import static net.saishovibes.back_in_classic.Back_In_Classic.MODID;
import static net.saishovibes.back_in_classic.registry.back_in_classic_blocks.*;

public interface back_in_classic_items {
    Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    //BLOCKS
    Item WAX_BLOCK_ITEM = register(new Identifier(Back_In_Classic.MODID, "wax_block"), new BlockItem(WAX_BLOCK, new FabricItemSettings()));
    Item CLASSIC_PORTAL_ITEM = register(new Identifier(Back_In_Classic.MODID, "classic_nether_portal"), new BlockItem(CLASSIC_NETHER_PORTAL, new FabricItemSettings()));
    Item COGWHEEL_ITEM = register(new Identifier(Back_In_Classic.MODID, "cogwheel"), new BlockItem(COGWHEEL, new FabricItemSettings()));
    Item DIRT_SLAB_ITEM = register(new Identifier(Back_In_Classic.MODID, "dirt_slab"), new BlockItem(DIRT_SLAB, new FabricItemSettings()));
    Item GEAR_ITEM = register(new Identifier(Back_In_Classic.MODID, "gear"), new BlockItem(GEAR, new FabricItemSettings()));
    Item GLOWING_OBSIDIAN_ITEM = register(new Identifier(Back_In_Classic.MODID, "glowing_obsidian"), new BlockItem(GLOWING_OBSIDIAN, new FabricItemSettings()));
    Item INF_LAVA_ITEM = register(new Identifier(Back_In_Classic.MODID, "infinite_lava"), new BlockItem(INF_LAVA, new FabricItemSettings()));
    Item INF_WATER_ITEM = register(new Identifier(Back_In_Classic.MODID, "infinite_water"), new BlockItem(INF_WATER, new FabricItemSettings()));
    Item REV_GEAR_ITEM = register(new Identifier(Back_In_Classic.MODID, "inverse_gear"), new BlockItem(REV_GEAR, new FabricItemSettings()));
    Item NETHER_REACTOR_ITEM = register(new Identifier(Back_In_Classic.MODID, "nether_reactor_core"), new BlockItem(NETHER_REACTOR, new FabricItemSettings()));
    Item SOD_BLOCK_ITEM = register(new Identifier(Back_In_Classic.MODID, "sod_block"), new BlockItem(SOD_BLOCK, new FabricItemSettings()));
    Item SOD_SLAB_ITEM = register(new Identifier(Back_In_Classic.MODID, "sod_slab"), new BlockItem(SOD_SLAB, new FabricItemSettings()));
    Item CRUSHED_GRAVEL_item = register(new Identifier(Back_In_Classic.MODID, "crushed_gravel"), new BlockItem(CRUSHED_GRAVEL, new FabricItemSettings()));

    //PLANTS
    Item BLUE_ROSE_ITEM = register(new Identifier(Back_In_Classic.MODID, "blue_rose"), new BlockItem(BLUE_ROSE, new FabricItemSettings()));
    Item RED_ROSE_ITEM = register(new Identifier(Back_In_Classic.MODID, "red_rose"), new BlockItem(RED_ROSE, new FabricItemSettings()));
    Item PAEONIA_ITEM = register(new Identifier(Back_In_Classic.MODID, "paeonia_flower"), new BlockItem(PAEONIA, new FabricItemSettings()));
    Item SHRUB_ITEM = register(new Identifier(Back_In_Classic.MODID, "shrub"), new BlockItem(SHRUB, new FabricItemSettings()));

    //CAULDRONS
    Item AWK_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "awkward_cauldron"), new BlockItem(AWKWARD_CAULDRON, new FabricItemSettings()));
    Item FIR_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "fire_cauldron"), new BlockItem(FIRE_RES_CAULDRON, new FabricItemSettings()));
    Item HAR_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "harm_cauldron"), new BlockItem(HARM_CAULDRON, new FabricItemSettings()));
    Item HEA_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "heal_cauldron"), new BlockItem(HEAL_CAULDRON, new FabricItemSettings()));
    Item INV_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "invis_cauldron"), new BlockItem(INVIS_CAULDRON, new FabricItemSettings()));
    Item JMP_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "jump_cauldron"), new BlockItem(JUMP_CAULDRON, new FabricItemSettings()));
    Item NVI_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "night_cauldron"), new BlockItem(NIGHT_VIS_CAULDRON, new FabricItemSettings()));
    Item POI_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "poison_cauldron"), new BlockItem(POISON_CAULDRON, new FabricItemSettings()));
    Item REG_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "regen_cauldron"), new BlockItem(REGEN_CAULDRON, new FabricItemSettings()));
    Item SLO_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "slow_cauldron"), new BlockItem(SLOW_CAULDRON, new FabricItemSettings()));
    Item SFA_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "slowfall_cauldron"), new BlockItem(SLOWFALL_CAULDRON, new FabricItemSettings()));
    Item SPE_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "speed_cauldron"), new BlockItem(SPEED_CAULDRON, new FabricItemSettings()));
    Item STR_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "strength_cauldron"), new BlockItem(STRENGTH_CAULDRON, new FabricItemSettings()));
    Item WBR_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "water_breathing_cauldron"), new BlockItem(WATER_BREATH_CAULDRON, new FabricItemSettings()));
    Item WEA_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "weakness_cauldron"), new BlockItem(WEAKNESS_CAULDRON, new FabricItemSettings()));
    Item TUR_CAULDRON_ITEM = register(new Identifier(Back_In_Classic.MODID, "turtle_master_cauldron"), new BlockItem(TURTLE_MASTER_CAULDRON, new FabricItemSettings()));

    //ARMOR
    //ArmorMaterial PlateArmorMaterial = new PlateArmorMaterial();
    //ArmorItem PLATE_HELMET = register(new Identifier(MODID, "plate_helmet"), new ArmorItem(PlateArmorMaterial, EquipmentSlot.HEAD, new Item.Settings()));
    //ArmorItem PLATE_CHESTPLATE = register(new Identifier(MODID, "plate_chestplate"), new ArmorItem(PlateArmorMaterial, EquipmentSlot.CHEST, new Item.Settings()));
    //ArmorItem PLATE_LEGGINGS = register(new Identifier(MODID, "plate_leggings"), new ArmorItem(PlateArmorMaterial, EquipmentSlot.LEGS, new Item.Settings()));
    //ArmorItem PLATE_BOOTS = register(new Identifier(MODID, "plate_boots"), new ArmorItem(PlateArmorMaterial, EquipmentSlot.FEET, new Item.Settings()));
    static <T extends Item> T register(Identifier id, T entry) {
        ITEMS.put(id, entry);
        return entry;
    }
    static void init() {
        ITEMS.forEach((id, entry) -> Registry.register(Registries.ITEM, id, entry));
    }
}
