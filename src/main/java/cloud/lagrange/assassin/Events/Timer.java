package cloud.lagrange.assassin.Events;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitRunnable;

import cloud.lagrange.assassin.Assassin;

public class Timer implements Runnable {
	private Assassin parent;
	public int seconds;
	public int jobId;  
	
	public Timer(Assassin parent, int seconds) {
		this.parent = parent;
		this.seconds = seconds;
	
	}
	
	public void start() {
		BukkitScheduler scheduler = this.parent.getServer().getScheduler();
    	BukkitTask task = scheduler.runTaskTimer(this.parent, this, 0, 20); //0 delay, period 20 ticks - 1 sec
    	this.jobId = task.getTaskId();
	}
	
	@Override
	public void run() {
		this.seconds--;
		
		if (this.seconds > 0) {
			Bukkit.broadcastMessage("Time left: "+ Integer.toString(this.seconds));
			return;
		} else {
			Bukkit.broadcastMessage("GO GO GO!");
			this.cancel();
			return;
		}
	}
	
	private void cancel() {
		if (this.jobId != -1) {
			this.parent.getServer().getScheduler().cancelTask(this.jobId);
		}
	}
}
