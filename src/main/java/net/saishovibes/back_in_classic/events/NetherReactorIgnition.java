package net.saishovibes.back_in_classic.events;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.random.*;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.saishovibes.back_in_classic.registry.BackInClassicBlocks;

public class NetherReactorIgnition {
    public static void activate() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (hand == Hand.MAIN_HAND && hitResult.getType() == HitResult.Type.BLOCK) {
                var pos = hitResult.getBlockPos();
                var state = world.getBlockState(pos);
                var block = state.getBlock();

                if (block == BackInClassicBlocks.NETHER_REACTOR) {
                    var itemStack = player.getMainHandStack();
                    if (itemStack.getItem() == Items.FLINT_AND_STEEL) {
                        if (block(world, pos.add(-1, -1, -1), Blocks.GOLD_BLOCK.getDefaultState()) &&
                                block(world, pos.add(-1, -1, 1), Blocks.GOLD_BLOCK.getDefaultState()) &&
                                block(world, pos.add(1, -1, -1), Blocks.GOLD_BLOCK.getDefaultState()) &&
                                block(world, pos.add(1, -1, 1), Blocks.GOLD_BLOCK.getDefaultState()) &&
                                /*Cobble Checks*/
                                block(world, pos.add(-1, 0, -1), Blocks.COBBLESTONE.getDefaultState()) &&
                                block(world, pos.add(-1, 0, 1), Blocks.COBBLESTONE.getDefaultState()) &&
                                block(world, pos.add(1, 0, -1), Blocks.COBBLESTONE.getDefaultState()) &&
                                block(world, pos.add(1, 0, 1), Blocks.COBBLESTONE.getDefaultState()) &&
                                block(world, pos.add(-1, -1, 0), Blocks.COBBLESTONE.getDefaultState()) &&
                                block(world, pos.add(0, -1, 1), Blocks.COBBLESTONE.getDefaultState()) &&
                                block(world, pos.add(0, -1, -1), Blocks.COBBLESTONE.getDefaultState()) &&
                                block(world, pos.add(1, -1, 0), Blocks.COBBLESTONE.getDefaultState()) &&
                                /*Top Block Checks*/
                                block(world, pos.add(-1, 1, 0), Blocks.COBBLESTONE.getDefaultState()) &&
                                block(world, pos.add(0, 1, 1), Blocks.COBBLESTONE.getDefaultState()) &&
                                block(world, pos.add(0, 1, -1), Blocks.COBBLESTONE.getDefaultState()) &&
                                block(world, pos.add(1, 1, 0), Blocks.COBBLESTONE.getDefaultState())) {
                            removeBlocks(world, pos);
                            //world.setBlockState(aboveBarrierSet, Blocks.BARRIER.getDefaultState());
                            if (!player.isCreative()) {
                                itemStack.use(world, player, hand);
                                itemStack.damage(1, player, playerEntity -> {});
                            }
                            world.playSound(null, pos, SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.MASTER, 1.0f, 1.0f);
                            ReactorPhase2.runScheduled(world, pos, 8000);
                            ReactorPhase3.runScheduled(world, pos, 16000);
                            ReactorPhase4.runScheduled(world, pos, 24000);
                            return ActionResult.SUCCESS;
                        }
                    }
                }
                return ActionResult.PASS;
            }
            return ActionResult.PASS;
        });
    }

    private static boolean block(World world, BlockPos pos, BlockState state) {
        var blockState = world.getBlockState(pos);
        return blockState.getBlock() == state.getBlock();
    }

    private static void removeBlocks(World world, BlockPos pos) {
        var corner1 = pos.add(-1, -1, -1);
        var corner2 = pos.add(1, 1, 1);

        var obsidian = BackInClassicBlocks.GLOWING_OBSIDIAN.getDefaultState();
        var gold = Blocks.NETHER_GOLD_ORE.getDefaultState();

        for (var x = corner1.getX(); x <= corner2.getX(); x++) {
            for (var y = corner1.getY(); y <= corner2.getY(); y++) {
                for (var z = corner1.getZ(); z <= corner2.getZ(); z++) {
                    var blockPos = new BlockPos(x, y, z);
                    if (world.getBlockState(blockPos).getBlock() == Blocks.GOLD_BLOCK) {
                        world.setBlockState(blockPos, gold);
                    }
                    if (world.getBlockState(blockPos).getBlock() == Blocks.COBBLESTONE) {
                        world.setBlockState(blockPos, obsidian);
                    }
                    if (world.getBlockState(blockPos).getBlock() == BackInClassicBlocks.NETHER_REACTOR) {
                        setPiglinSpawner(world, pos);
                    }
                }
            }
        }
    }

    public static void setPiglinSpawner(World world, BlockPos pos) {
        var spawnerState = Blocks.SPAWNER.getDefaultState();
        world.setBlockState(pos, Blocks.ANCIENT_DEBRIS.getDefaultState());
        world.setBlockState(pos, spawnerState);

        var blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof MobSpawnerBlockEntity) {
            var state = Blocks.SPAWNER.getDefaultState();
            world.setBlockState(pos, state);
            MobSpawnerBlockEntity spawnerEntity = (MobSpawnerBlockEntity) blockEntity;
            var mobSpawnerLogic = ((MobSpawnerBlockEntity) blockEntity).getLogic();
            var randNum = Random.create(world.getTimeOfDay());
            mobSpawnerLogic.setEntityId(EntityType.ZOMBIFIED_PIGLIN, world, randNum, pos);
            blockEntity.markDirty();
            world.updateListeners(pos, state, state, 3);
        }
    }

    public static void setBruteSpawner(World world, BlockPos pos) {
        var spawnerState = Blocks.SPAWNER.getDefaultState();
        //world.setBlockState(pos, Blocks.ANCIENT_DEBRIS.getDefaultState());
        world.setBlockState(pos, spawnerState);

        var blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof MobSpawnerBlockEntity) {
            var state = Blocks.SPAWNER.getDefaultState();
            world.setBlockState(pos, state);
            MobSpawnerBlockEntity spawnerEntity = (MobSpawnerBlockEntity) blockEntity;
            var mobSpawnerLogic = ((MobSpawnerBlockEntity) blockEntity).getLogic();
            Random randNum = new ThreadSafeRandom(world.getTimeOfDay());
            mobSpawnerLogic.setEntityId(EntityType.PIGLIN_BRUTE, world, randNum, pos);
            blockEntity.markDirty();
            world.updateListeners(pos, state, state, 3);
        }
    }

    public static void setBlazeSpawner(World world, BlockPos pos) {
        var spawnerState = Blocks.SPAWNER.getDefaultState();
        //world.setBlockState(pos, Blocks.ANCIENT_DEBRIS.getDefaultState());
        world.setBlockState(pos, spawnerState);

        var blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof MobSpawnerBlockEntity) {
            var state = Blocks.SPAWNER.getDefaultState();
            world.setBlockState(pos, state);
            var mobSpawnerLogic = ((MobSpawnerBlockEntity)blockEntity).getLogic();
            Random randNum = new ThreadSafeRandom(world.getTimeOfDay());
            mobSpawnerLogic.setEntityId(EntityType.BLAZE, world, randNum, pos);
            blockEntity.markDirty();
            world.updateListeners(pos, state, state, 3);
        }
    }

    public static void spawnerShutdown(World world, BlockPos pos) {
        world.setBlockState(pos, BackInClassicBlocks.GLOWING_OBSIDIAN.getDefaultState());
    }
}