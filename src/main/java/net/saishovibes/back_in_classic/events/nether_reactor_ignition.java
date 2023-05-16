package net.saishovibes.back_in_classic.events;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.command.PlaceCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.random.*;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.Structure;
import net.saishovibes.back_in_classic.registry.back_in_classic_blocks;

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
                            //world.setBlockState(aboveBarrierSet, Blocks.BARRIER.getDefaultState());
                            if (!player.isCreative()) {
                                itemStack.use(world, player, hand);
                                itemStack.damage(1, player, playerEntity -> {});
                            }
                            world.playSound(null, pos, SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.MASTER, 1.0f, 1.0f);
                            //ScheduleTask.runScheduled(world, pos, 5000);

                            reactor_phase_2.runScheduled(world, pos, 8000);
                            reactor_phase_3.runScheduled(world, pos, 16000);
                            reactor_phase_4.runScheduled(world, pos, 24000);
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
        BlockState zombiePiglinSpawner = Blocks.SPAWNER.getDefaultState();

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
                        set_piglin_spawner(world, pos);
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
            set_piglin_spawner(world, pos);
            world.setBlockState(belowCheck, Blocks.BARRIER.getDefaultState());
        }else if (world.getBlockState(aboveCheck).getBlock() == Blocks.BARRIER &&
                world.getBlockState(belowCheck).getBlock() == Blocks.BARRIER) {
            set_blaze_spawner(world, pos);
            world.setBlockState(aboveCheck, Blocks.AIR.getDefaultState());
            world.setBlockState(belowCheck, Blocks.AIR.getDefaultState());
        }else {
            world.setBlockState(pos, back_in_classic_blocks.GLOWING_OBSIDIAN.getDefaultState());
        }
    }
    public static void set_piglin_spawner(World world, BlockPos pos) {
        BlockState spawnerState = Blocks.SPAWNER.getDefaultState();
        world.setBlockState(pos, Blocks.ANCIENT_DEBRIS.getDefaultState());
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
    public static void set_brute_spawner(World world, BlockPos pos) {
        BlockState spawnerState = Blocks.SPAWNER.getDefaultState();
        //world.setBlockState(pos, Blocks.ANCIENT_DEBRIS.getDefaultState());
        world.setBlockState(pos, spawnerState);

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof MobSpawnerBlockEntity) {
            BlockState state = Blocks.SPAWNER.getDefaultState();
            world.setBlockState(pos, state);
            if(blockEntity instanceof MobSpawnerBlockEntity spawnerEntity) {
                MobSpawnerLogic mobSpawnerLogic = ((MobSpawnerBlockEntity)blockEntity).getLogic();
                Random randNum = new ThreadSafeRandom(world.getTimeOfDay());
                mobSpawnerLogic.setEntityId(EntityType.PIGLIN_BRUTE, world, randNum, pos);
                blockEntity.markDirty();
                world.updateListeners(pos, state, state, 3);
            }
        }
    }
    public static void set_blaze_spawner(World world, BlockPos pos) {
        BlockState spawnerState = Blocks.SPAWNER.getDefaultState();
        //world.setBlockState(pos, Blocks.ANCIENT_DEBRIS.getDefaultState());
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
    public static void spawner_shutdown(World world, BlockPos pos) {
        world.setBlockState(pos, back_in_classic_blocks.GLOWING_OBSIDIAN.getDefaultState());
    }

    //old code to delete
    public static void debris_structure(World world, BlockPos pos) throws CommandSyntaxException {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ServerCommandSource source = minecraftClient.player.getCommandSource();
        RegistryEntry.Reference<Structure> debris_ref = world.getRegistryManager().getWrapperOrThrow(RegistryKeys.STRUCTURE)
                .getOrThrow(RegistryKey.of(RegistryKeys.STRUCTURE,
                        new Identifier("back_in_classic", "nether_reactor_debris")));
        BlockPos newpos = new BlockPos(pos.getX() - 11 , pos.getY() - 1, pos.getZ() - 11);

        PlaceCommand.executePlaceStructure(source, debris_ref, newpos);
    }
//String command = "place structure back_in_classic:nether_reactor_debris ~-11 ~-1 ~-11";
    //String command = "place structure minecraft:bastion_remnant ~-15 ~-1 ~-15";
    //minecraftClient.getNetworkHandler().getCommandDispatcher().execute(command, source);
}