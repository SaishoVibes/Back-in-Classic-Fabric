package net.saishovibes.backinclassic.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class PotionCauldronBlock extends Block {
    public static final Map<Potion, PotionCauldronBlock> CAULDRONS = new HashMap<>();
    public final Potion potion;

    public PotionCauldronBlock(Potion potion, Settings settings) {
        super(settings);
        this.potion = potion;
        CAULDRONS.put(potion, this);
    }

    public static @NotNull PotionCauldronBlock of(Potion potion) {
        return new PotionCauldronBlock(potion, FabricBlockSettings.copyOf(Blocks.CAULDRON).nonOpaque());
    }
}