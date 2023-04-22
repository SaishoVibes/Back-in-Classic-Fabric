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

                //MAKING CAULDRONS
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
                if (block == Blocks.WATER_CAULDRON && state.get(LeveledCauldronBlock.LEVEL) == 3) {
                    ItemStack itemStack = player.getMainHandStack();
                    if (itemStack.getItem() == Items.FERMENTED_SPIDER_EYE) {
                        world.setBlockState(blockPos, back_in_classic_blocks.WEAKNESS_CAULDRON.getDefaultState());
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
                    if (itemStack.getItem() == Items.SUGAR) {
                        world.setBlockState(blockPos, back_in_classic_blocks.SPEED_CAULDRON.getDefaultState());
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
                    if (itemStack.getItem() == Items.RABBIT_FOOT) {
                        world.setBlockState(blockPos, back_in_classic_blocks.JUMP_CAULDRON.getDefaultState());
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
                    if (itemStack.getItem() == Items.BLAZE_POWDER) {
                        world.setBlockState(blockPos, back_in_classic_blocks.STRENGTH_CAULDRON.getDefaultState());
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
                    if (itemStack.getItem() == Items.GLISTERING_MELON_SLICE) {
                        world.setBlockState(blockPos, back_in_classic_blocks.HEAL_CAULDRON.getDefaultState());
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
                    if (itemStack.getItem() == Items.SPIDER_EYE) {
                        world.setBlockState(blockPos, back_in_classic_blocks.POISON_CAULDRON.getDefaultState());
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
                    if (itemStack.getItem() == Items.GHAST_TEAR) {
                        world.setBlockState(blockPos, back_in_classic_blocks.REGEN_CAULDRON.getDefaultState());
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
                    if (itemStack.getItem() == Items.MAGMA_CREAM) {
                        world.setBlockState(blockPos, back_in_classic_blocks.FIRE_RES_CAULDRON.getDefaultState());
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
                    if (itemStack.getItem() == Items.PUFFERFISH) {
                        world.setBlockState(blockPos, back_in_classic_blocks.WATER_BREATH_CAULDRON.getDefaultState());
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
                    if (itemStack.getItem() == Items.GOLDEN_CARROT) {
                        world.setBlockState(blockPos, back_in_classic_blocks.NIGHT_VIS_CAULDRON.getDefaultState());
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
                /*
                Insert Turtle Master Cauldron Here in 0.0.5
                 */
                if (block == back_in_classic_blocks.AWKWARD_CAULDRON) {
                    ItemStack itemStack = player.getMainHandStack();
                    if (itemStack.getItem() == Items.PHANTOM_MEMBRANE) {
                        world.setBlockState(blockPos, back_in_classic_blocks.SLOWFALL_CAULDRON.getDefaultState());
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
                if (block == back_in_classic_blocks.SPEED_CAULDRON || block == back_in_classic_blocks.JUMP_CAULDRON) {
                    ItemStack itemStack = player.getMainHandStack();
                    if (itemStack.getItem() == Items.FERMENTED_SPIDER_EYE) {
                        world.setBlockState(blockPos, back_in_classic_blocks.SLOW_CAULDRON.getDefaultState());
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
                if (block == back_in_classic_blocks.HEAL_CAULDRON || block == back_in_classic_blocks.POISON_CAULDRON) {
                    ItemStack itemStack = player.getMainHandStack();
                    if (itemStack.getItem() == Items.FERMENTED_SPIDER_EYE) {
                        world.setBlockState(blockPos, back_in_classic_blocks.HARM_CAULDRON.getDefaultState());
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
                if (block == back_in_classic_blocks.NIGHT_VIS_CAULDRON) {
                    ItemStack itemStack = player.getMainHandStack();
                    if (itemStack.getItem() == Items.FERMENTED_SPIDER_EYE) {
                        world.setBlockState(blockPos, back_in_classic_blocks.INVIS_CAULDRON.getDefaultState());
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
                //
                //COLLECTING POTIONS
                //
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
                if (block == back_in_classic_blocks.NIGHT_VIS_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:night_vision");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.SPEED_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:swiftness");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.JUMP_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:leaping");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.FIRE_RES_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:fire_resistance");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.POISON_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:poison");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.HEAL_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:healing");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.HARM_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:harming");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.INVIS_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:invisibility");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.WATER_BREATH_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:water_breathing");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.SLOW_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:slowness");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.SLOWFALL_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:slow_falling");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.WEAKNESS_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:weakness");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.STRENGTH_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:strength");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                if (block == back_in_classic_blocks.REGEN_CAULDRON) {
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
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:regeneration");
                        ItemEntity itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    }
                }
                /*
                Insert Turtle Master in 0.0.5
                 */
            }
            return ActionResult.PASS;
        });
    }
}