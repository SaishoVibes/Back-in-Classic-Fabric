package net.saishovibes.back_in_classic.events;

import net.minecraft.server.world.ServerWorld;
import net.saishovibes.back_in_classic.Back_In_Classic;
import net.minecraft.command.CommandSource;
import net.minecraft.command.BlockDataObject;
import net.minecraft.server.*;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.StringHelper;
import net.minecraft.world.World;
import net.minecraft.world.*;

import java.util.Map;

public class NetherReactor {
    /*public static void executeProcedure(Map<String, Object> dependencies) {
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x"))
                Back_In_Classic.LOGGER.warn("Failed to load dependency x for procedure NetherReaction!");
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y"))
                Back_In_Classic.LOGGER.warn("Failed to load dependency y for procedure NetherReaction!");
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z"))
                Back_In_Classic.LOGGER.warn("Failed to load dependency z for procedure NetherReaction!");
            return;
        }
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world"))
                Back_In_Classic.LOGGER.warn("Failed to load dependency world for procedure NetherReaction!");
            return;
        }
        double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
        double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
        double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
        IWorld world = (IWorld) dependencies.get("world");
        if (world instanceof ServerWorld) {
            ((World) world).getServer().getCommandManager().handleCommand(
                    new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                            new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                    "fill ~-8 ~-2 ~-8 ~8 ~-2 ~8 netherrack replace air");
        }
        if (world instanceof ServerWorld) {
            ((World) world).getServer().getCommandManager().handleCommand(
                    new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                            new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                    "fill ~-8 ~30 ~-8 ~8 ~30 ~8 netherrack replace air");
        }
        if ((1 == 1)) {
            if (world instanceof ServerWorld) {
                ((World) world).getServer().getCommandManager().handleCommand(
                        new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                                new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                        "fill ~-8 ~-2 ~-8 ~8 ~30 ~-8 netherrack replace air");
            }
            if (world instanceof ServerWorld) {
                ((World) world).getServer().getCommandManager().handleCommand(
                        new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                                new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                        "fill ~-8 ~-2 ~-8 ~-8 ~30 ~8 netherrack replace air");
            }
            if (world instanceof ServerWorld) {
                ((World) world).getServer().getCommandManager().handleCommand(
                        new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                                new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                        "fill ~8 ~-2 ~8 ~8 ~30 ~-8 netherrack replace air");
            }
            if (world instanceof ServerWorld) {
                ((World) world).getServer().getCommandManager().handleCommand(
                        new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                                new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                        "fill ~8 ~-2 ~8 ~-8 ~30 ~8 netherrack replace air");
            }
        }
        if (world instanceof ServerWorld) {
            ((World) world).getServer().getCommandManager().handleCommand(
                    new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                            new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                    "fill ~-1 ~-1 ~-1 ~1 ~1 ~1 back_in_classic:glowing_obsidian replace cobblestone");
        }
        if (world instanceof ServerWorld) {
            ((World) world).getServer().getCommandManager().handleCommand(
                    new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                            new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                    "fill ~-1 ~-1 ~-1 ~1 ~-1 ~1 spawner{SpawnData:{id:\"minecraft:piglin\"}} replace gold_block");
        }
        if (world instanceof ServerWorld) {
            ((World) world).getServer().getCommandManager().handleCommand(
                    new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                            new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                    "setblock ~ ~ ~ spawner{SpawnData:{id:\"minecraft:blaze\"}}");
        }
        new Object() {
            private int ticks = 0;
            private float waitTicks;
            private IWorld world;
            public void start(IWorld world, int waitTicks) {
                this.waitTicks = waitTicks;
                .register(this);
                this.world = world;
            }

            @SubscribeEvent
            public void tick(TickEvent.ServerTickEvent event) {
                if (event.phase == TickEvent.Phase.END) {
                    this.ticks += 1;
                    if (this.ticks >= this.waitTicks)
                        run();
                }
            }

            private void run() {
                if (world instanceof ServerWorld) {
                    ((World) world).getServer().getCommandManager().handleCommand(
                            new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                                    new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                            "fill ~-1 ~-1 ~-1 ~1 ~-1 ~1 nether_gold_ore replace spawner");
                }
                if (world instanceof ServerWorld) {
                    ((World) world).getServer().getCommandManager().handleCommand(
                            new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
                                    new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
                            "setblock ~ ~ ~ crying_obsidian");
                }
                MinecraftForge.EVENT_BUS.unregister(this);
            }
        }.start(world, (int) 600);
    }*/
}
