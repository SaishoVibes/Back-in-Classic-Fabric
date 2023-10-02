package net.saishovibes.back_in_classic.events;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Timer;
import java.util.TimerTask;

public class ReactorPhase3 extends TimerTask {

    private final BlockPos pos;
    private final World world;

    public ReactorPhase3(World world, BlockPos pos) {
        this.pos = pos;
        this.world = world;
    }

    @Override
    public void run() {
        //Execute your task
        NetherReactorIgnition.setBruteSpawner(world, pos);
    }

    public static void runScheduled(World world, BlockPos pos, long delayInMillis) {
        new Timer().schedule(new ReactorPhase3(world, pos), delayInMillis);
    }
}
