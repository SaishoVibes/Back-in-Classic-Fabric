package net.saishovibes.back_in_classic.events;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;

import net.saishovibes.back_in_classic.registry.back_in_classic_blocks;
import net.saishovibes.back_in_classic.registry.back_in_classic_items;
public class cauldron_brewing {
    public static void initialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (hand == Hand.MAIN_HAND && hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
                BlockState state = world.getBlockState(blockPos);
                Block block = state.getBlock();

                if (block == Blocks.WATER_CAULDRON && state.get(LeveledCauldronBlock.LEVEL) == 3) {
                    ItemStack itemStack = player.getMainHandStack();
                    if (itemStack.getItem() == Items.NETHER_WART) {
                        world.setBlockState(blockPos, back_in_classic_blocks.AWKWARD_CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        // Play a sound and particles to indicate successful interaction
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        // Play a sound and particles to indicate successful interaction
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.AWKWARD_CAULDRON) {
                    ItemStack itemStack = player.getMainHandStack();
                    if (itemStack.getItem() == Items.GLASS_BOTTLE) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        // Play a sound and particles to indicate successful interaction
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        // Play a sound and particles to indicate successful interaction
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        // Drop an Awkward Potion item
                        // Spawn an awkward potion item entity
                        ItemStack awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:awkward");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
            }
            return ActionResult.PASS;
        });
    }
}