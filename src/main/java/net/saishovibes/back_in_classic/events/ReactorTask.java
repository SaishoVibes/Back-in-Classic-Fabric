package net.saishovibes.back_in_classic.events;

import java.util.Timer;
import java.util.TimerTask;

public class ReactorTask extends TimerTask {
    private final Runnable task;

    public ReactorTask(Runnable task) {
        this.task = task;
    }

    @Override
    public void run() {
        this.task.run();
    }

    public static void runScheduled(Runnable task, long delayInMillis) {
        new Timer().schedule(new ReactorTask(task), delayInMillis);
    }
}