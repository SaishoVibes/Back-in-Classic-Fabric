package net.saishovibes.back_in_classic.events;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Timer;
import java.util.TimerTask;

public class reactor_phase_4 extends TimerTask {

    private final BlockPos pos;
    private final World world;

    public reactor_phase_4(World world, BlockPos pos) {
        this.pos = pos;
        this.world = world;
    }

    @Override
    public void run() {
        //Execute your task
        nether_reactor_ignition.spawner_shutdown(world, pos);
    }

    public static void runScheduled(World world, BlockPos pos, long delayInMillis) {
        new Timer().schedule(new reactor_phase_4(world, pos), delayInMillis);
    }
}
