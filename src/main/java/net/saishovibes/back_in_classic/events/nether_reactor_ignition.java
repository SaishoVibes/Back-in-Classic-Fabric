package net.saishovibes.back_in_classic.events;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.nbt.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.*;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.World;
import net.minecraft.world.biome.SpawnSettings;
import net.saishovibes.back_in_classic.Back_In_Classic;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.saishovibes.back_in_classic.registry.back_in_classic_blocks;
import net.minecraft.block.entity.BlockEntityType;
import java.util.Map;
import java.util.random.*;
import java.util.Timer;
import java.util.TimerTask;
import net.saishovibes.back_in_classic.events.ScheduleTask;

import net.minecraft.nbt.NbtCompound.*;

public class nether_reactor_ignition {
    //public static void activate(World findWorld, BlockPos pos) {
    public static void activate() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (hand == Hand.MAIN_HAND && hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos pos = ((BlockHitResult) hitResult).getBlockPos();
                BlockState state = world.getBlockState(pos);
                Block block = state.getBlock();

                if (block == back_in_classic_blocks.NETHER_REACTOR) {
                    ItemStack itemStack = player.getMainHandStack();
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
                            BlockPos aboveBarrierSet = new BlockPos(pos.getX(),pos.getY()+1,pos.getZ());
                            world.setBlockState(aboveBarrierSet, Blocks.BARRIER.getDefaultState());
                            if (!player.isCreative()) {
                                itemStack.use(world, player, hand);
                                itemStack.damage(1, player, playerEntity -> {});
                            }
                            world.playSound(null, pos, SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.MASTER, 1.0f, 1.0f);
                            //ScheduleTask.runScheduled(world, pos, 5000);
                            ScheduleTask.runScheduled(world, pos, 10000);
                            ScheduleTask.runScheduled(world, pos, 15000);
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
        BlockState blockState = world.getBlockState(pos);
        return blockState.getBlock() == state.getBlock();
    }

    private static void removeBlocks(World world, BlockPos pos) {
        BlockPos corner1 = pos.add(-1, -1, -1);
        BlockPos corner2 = pos.add(1, 1, 1);

        BlockState obsidian = back_in_classic_blocks.GLOWING_OBSIDIAN.getDefaultState();
        BlockState gold = Blocks.NETHER_GOLD_ORE.getDefaultState();
        //BlockState zombiePiglinSpawner = Blocks.SPAWNER.getDefaultState();

        for (int x = corner1.getX(); x <= corner2.getX(); x++) {
            for (int y = corner1.getY(); y <= corner2.getY(); y++) {
                for (int z = corner1.getZ(); z <= corner2.getZ(); z++) {
                    BlockPos blockPos = new BlockPos(x, y, z);
                    if (world.getBlockState(blockPos).getBlock() == Blocks.GOLD_BLOCK) {
                        world.setBlockState(blockPos, gold);
                    }
                    if (world.getBlockState(blockPos).getBlock() == Blocks.COBBLESTONE) {
                        world.setBlockState(blockPos, obsidian);
                    }
                    if (world.getBlockState(blockPos).getBlock() == back_in_classic_blocks.NETHER_REACTOR) {
                        setPiglinSpawner(world, pos);
                    }
                }
            }
        }
    }

    public static void spawnerChooser(World world, BlockPos pos) {
        BlockPos aboveCheck = new BlockPos(pos.getX(),pos.getY()+1,pos.getZ());
        BlockPos belowCheck = new BlockPos(pos.getX(),pos.getY()+1,pos.getZ());
        if (world.getBlockState(aboveCheck).getBlock() == Blocks.BARRIER &&
                world.getBlockState(belowCheck).getBlock() == back_in_classic_blocks.GLOWING_OBSIDIAN) {
            setPiglinSpawner(world, pos);
            world.setBlockState(belowCheck, Blocks.BARRIER.getDefaultState());
        }else if (world.getBlockState(aboveCheck).getBlock() == Blocks.BARRIER &&
                world.getBlockState(belowCheck).getBlock() == Blocks.BARRIER) {
            setBlazeSpawner(world, pos);
            world.setBlockState(aboveCheck, Blocks.AIR.getDefaultState());
            world.setBlockState(belowCheck, Blocks.AIR.getDefaultState());
        }else {
            world.setBlockState(pos, back_in_classic_blocks.GLOWING_OBSIDIAN.getDefaultState());
        }
    }
    public static void setPiglinSpawner(World world, BlockPos pos) {
        BlockState spawnerState = Blocks.SPAWNER.getDefaultState();
        world.setBlockState(pos, spawnerState);

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof MobSpawnerBlockEntity) {
            BlockState state = Blocks.SPAWNER.getDefaultState();
            world.setBlockState(pos, state);
            if(blockEntity instanceof MobSpawnerBlockEntity spawnerEntity) {
                MobSpawnerLogic mobSpawnerLogic = ((MobSpawnerBlockEntity)blockEntity).getLogic();
                Random randNum = new ThreadSafeRandom(world.getTimeOfDay());
                mobSpawnerLogic.setEntityId(EntityType.ZOMBIFIED_PIGLIN, world, randNum, pos);
                blockEntity.markDirty();
                world.updateListeners(pos, state, state, 3);
            }
        }
    }
    public static void setBlazeSpawner(World world, BlockPos pos) {
        BlockState spawnerState = Blocks.SPAWNER.getDefaultState();
        world.setBlockState(pos, spawnerState);

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof MobSpawnerBlockEntity) {
            BlockState state = Blocks.SPAWNER.getDefaultState();
            world.setBlockState(pos, state);
            if(blockEntity instanceof MobSpawnerBlockEntity spawnerEntity) {
                MobSpawnerLogic mobSpawnerLogic = ((MobSpawnerBlockEntity)blockEntity).getLogic();
                Random randNum = new ThreadSafeRandom(world.getTimeOfDay());
                mobSpawnerLogic.setEntityId(EntityType.BLAZE, world, randNum, pos);
                blockEntity.markDirty();
                world.updateListeners(pos, state, state, 3);
            }
        }
    }
}