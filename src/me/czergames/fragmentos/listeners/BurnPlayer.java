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
					if(!p.getItemInHand().hasItemMeta()) continue;
					if(!p.getItemInHand().getItemMeta().hasDisplayName()) continue;
					if(!p.getItemInHand().getItemMeta().hasLore()) continue;
					
					if(p.getItemInHand().getItemMeta().getDisplayName().equals(
							FragmentosCmd.getVulcanic().getItemMeta().getDisplayName())
							&& p.getItemInHand().getItemMeta().getLore().equals(
									FragmentosCmd.getVulcanic().getItemMeta().getLore())) {
						
						p.setFireTicks(40);
					}
				}
			}
		}, 0, 10);
	}

}
