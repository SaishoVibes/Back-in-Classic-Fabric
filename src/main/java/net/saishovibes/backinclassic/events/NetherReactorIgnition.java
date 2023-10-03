package net.saishovibes.backinclassic.events;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.saishovibes.backinclassic.registry.BackInClassicBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

public class NetherReactorIgnition {
    public static ActionResult interact(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        if (hand == Hand.MAIN_HAND && hitResult.getType() == HitResult.Type.BLOCK) {
            var pos = hitResult.getBlockPos();
            var state = world.getBlockState(pos);
            var block = state.getBlock();
            if (block == BackInClassicBlocks.NETHER_REACTOR) {
                var itemStack = player.getMainHandStack();
                if (itemStack.getItem() == Items.FLINT_AND_STEEL) {
                    for (var i = -1; i <= 1; i++) {
                        for (var j = -1; j <= 1; j++) {
                            for (var k = -1; k <= 1; k++) {
                                var length = Math.abs(i) + Math.abs(j) + Math.abs(k);
                                var offBlock = world.getBlockState(pos.add(i, j, k)).getBlock();
                                if (length == 2 && offBlock != Blocks.COBBLESTONE) {
                                    return ActionResult.PASS;
                                }
                                if (length == 3 && j == -1 && offBlock != Blocks.GOLD_BLOCK) {
                                    return ActionResult.PASS;
                                }
                            }
                        }
                    }
                    for (var i = -1; i <= 1; i++) {
                        for (var j = -1; j <= 1; j++) {
                            for (var k = -1; k <= 1; k++) {
                                var length = Math.abs(i) + Math.abs(j) + Math.abs(k);
                                var offPos = pos.add(i, j, k);
                                if (length == 0) {
                                    setSpawner(world, offPos, EntityType.PIGLIN);
                                } else if (length == 2) {
                                    world.setBlockState(offPos, BackInClassicBlocks.GLOWING_OBSIDIAN.getDefaultState());
                                } else if (length == 3 && j == -1) {
                                    world.setBlockState(offPos, Blocks.NETHER_GOLD_ORE.getDefaultState());
                                }
                            }
                        }
                    }
                    if (!player.isCreative()) {
                        itemStack.use(world, player, hand);
                        itemStack.damage(1, player, playerEntity -> {
                        });
                    }
                    world.playSound(null, pos, SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.MASTER, 1.0f, 1.0f);
                    new ReactorTask(() -> NetherReactorIgnition.setSpawner(world, pos, EntityType.BLAZE), 8000);
                    new ReactorTask(() -> NetherReactorIgnition.setSpawner(world, pos, EntityType.PIGLIN_BRUTE), 16000);
                    new ReactorTask(() -> world.setBlockState(pos, BackInClassicBlocks.GLOWING_OBSIDIAN.getDefaultState()), 24000);
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        }
        return ActionResult.PASS;
    }

    public static void setSpawner(@NotNull World world, BlockPos pos, EntityType<?> entityType) {
        var spawnerState = Blocks.SPAWNER.getDefaultState();
        world.setBlockState(pos, spawnerState);
        var blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof MobSpawnerBlockEntity spawnerBlock) {
            var state = Blocks.SPAWNER.getDefaultState();
            world.setBlockState(pos, state);
            spawnerBlock.getLogic().setEntityId(entityType, world, world.random, pos);
            blockEntity.markDirty();
            world.updateListeners(pos, state, state, 3);
        }
    }

    private static class ReactorTask extends TimerTask {
        private final Runnable task;

        public ReactorTask(Runnable task, long delayInMillis) {
            this.task = task;
            new Timer().schedule(this, delayInMillis);
        }

        @Override
        public void run() {
            this.task.run();
        }
    }
}