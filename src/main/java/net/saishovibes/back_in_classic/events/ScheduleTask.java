package net.saishovibes.back_in_classic.events;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.saishovibes.back_in_classic.registry.back_in_classic_blocks;
import net.saishovibes.back_in_classic.registry.back_in_classic_items;
import java.util.Timer;
import java.util.TimerTask;
import net.saishovibes.back_in_classic.events.nether_reactor_ignition;

public class ScheduleTask extends TimerTask {

    private final BlockPos pos;
    private final World world;

    public ScheduleTask(World world, BlockPos pos) {
        this.pos = pos;
        this.world = world;
    }

    @Override
    public void run() {
        //Execute your task
        nether_reactor_ignition.spawnerChooser(world, pos);
    }

    public static void runScheduled(World world, BlockPos pos, long delayInMillis) {
        new Timer().schedule(new ScheduleTask(world, pos), delayInMillis);
    }
}
