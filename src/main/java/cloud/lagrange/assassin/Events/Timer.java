package cloud.lagrange.assassin.Events;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitRunnable;

import cloud.lagrange.assassin.Assassin;

public class Timer extends BukkitRunnable {
	private Assassin parent;
	public int seconds;
	
	public Timer(Assassin parent, int seconds) {
		this.parent = parent;
		this.seconds = seconds;
	
	}
	
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
}
