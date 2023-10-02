package net.saishovibes.back_in_classic.events;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.saishovibes.back_in_classic.registry.BackInClassicBlocks;

public class CauldronBrewing {
    public static void initialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (hand == Hand.MAIN_HAND && hitResult.getType() == HitResult.Type.BLOCK) {
                var blockPos = hitResult.getBlockPos();
                var state = world.getBlockState(blockPos);
                var block = state.getBlock();
                var itemStack = player.getMainHandStack();
                BlockState newState = null;

                if (block == Blocks.WATER_CAULDRON && state.get(LeveledCauldronBlock.LEVEL) == 3) {
                    if (itemStack.getItem() == Items.NETHER_WART) {
                        newState = BackInClassicBlocks.AWKWARD_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.FERMENTED_SPIDER_EYE) {
                        newState = BackInClassicBlocks.WEAKNESS_CAULDRON.getDefaultState();
                    }
                } else if (block == BackInClassicBlocks.AWKWARD_CAULDRON) {
                    if (itemStack.getItem() == Items.SUGAR) {
                        newState = BackInClassicBlocks.SPEED_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.RABBIT_FOOT) {
                        newState = BackInClassicBlocks.JUMP_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.BLAZE_POWDER) {
                        newState = BackInClassicBlocks.STRENGTH_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.GLISTERING_MELON_SLICE) {
                        newState = BackInClassicBlocks.HEAL_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.SPIDER_EYE) {
                        newState = BackInClassicBlocks.POISON_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.GHAST_TEAR) {
                        newState = BackInClassicBlocks.REGEN_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.MAGMA_CREAM) {
                        newState = BackInClassicBlocks.FIRE_RES_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.PUFFERFISH) {
                        newState = BackInClassicBlocks.WATER_BREATH_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.GOLDEN_CARROT) {
                        newState = BackInClassicBlocks.NIGHT_VIS_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.TURTLE_HELMET) {
                        newState = BackInClassicBlocks.TURTLE_MASTER_CAULDRON.getDefaultState();
                    } else if (itemStack.getItem() == Items.PHANTOM_MEMBRANE) {
                        newState = BackInClassicBlocks.SLOWFALL_CAULDRON.getDefaultState();
                    }
                } else if (block == BackInClassicBlocks.SPEED_CAULDRON || block == BackInClassicBlocks.JUMP_CAULDRON) {
                    if (itemStack.getItem() == Items.FERMENTED_SPIDER_EYE) {
                        newState = BackInClassicBlocks.SLOW_CAULDRON.getDefaultState();
                    }
                } else if (block == BackInClassicBlocks.HEAL_CAULDRON || block == BackInClassicBlocks.POISON_CAULDRON) {
                    if (itemStack.getItem() == Items.FERMENTED_SPIDER_EYE) {
                        newState = BackInClassicBlocks.HARM_CAULDRON.getDefaultState();
                    }
                } else if (block == BackInClassicBlocks.NIGHT_VIS_CAULDRON) {
                    if (itemStack.getItem() == Items.FERMENTED_SPIDER_EYE) {
                        newState = BackInClassicBlocks.INVIS_CAULDRON.getDefaultState();
                    }
                }
                if (newState != null) {
                    world.setBlockState(blockPos, newState);
                    if (!player.isCreative()) {
                        itemStack.decrement(1);
                    }
                    world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                    var serverWorld = (ServerWorld) world;
                    serverWorld.spawnParticles(ParticleTypes.ENCHANT, blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5, 50, 0.5, 0.5, 0.5, 0.5);
                    world.addParticle(ParticleTypes.ENCHANT, blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5, 50, 0.5, 0.5);
                    return ActionResult.SUCCESS;
                }


                if (itemStack.getItem() == Items.GLASS_BOTTLE) {
                    if (block == BackInClassicBlocks.AWKWARD_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:awkward");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.NIGHT_VIS_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:night_vision");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.SPEED_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:swiftness");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.JUMP_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:leaping");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.FIRE_RES_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:fire_resistance");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.POISON_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:poison");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.HEAL_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:healing");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.HARM_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:harming");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.INVIS_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:invisibility");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.WATER_BREATH_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:water_breathing");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.SLOW_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:slowness");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.SLOWFALL_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:slow_falling");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.WEAKNESS_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:weakness");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.STRENGTH_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:strength");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.REGEN_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:regeneration");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
                        itemEntity.setToDefaultPickupDelay();
                        world.spawnEntity(itemEntity);
                        return ActionResult.SUCCESS;
                    } else if (block == BackInClassicBlocks.TURTLE_MASTER_CAULDRON) {
                        world.setBlockState(blockPos, Blocks.CAULDRON.getDefaultState());
                        if (!player.isCreative()) {
                            itemStack.decrement(1);
                        }
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        var awkwardPotion = new ItemStack(Items.POTION);
                        awkwardPotion.getOrCreateNbt().putString("Potion", "minecraft:turtle_master");
                        var itemEntity = new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY() + 1.0, blockPos.getZ() + 0.5, awkwardPotion);
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