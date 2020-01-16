package me.czergames.fragmentos.listeners;

import me.czergames.fragmentos.Main;
import me.czergames.fragmentos.commands.FragmentosCmd;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BurnPlayer {
	
	public static void checkVulcanic() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(p.getItemInHand().equals(FragmentosCmd.getVulcanic())) {
						p.setFireTicks(40);
					}
				}
			}
		}, 0, 10);
	}
	
}
