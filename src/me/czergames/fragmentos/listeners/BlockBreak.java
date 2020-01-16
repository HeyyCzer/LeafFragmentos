package me.czergames.fragmentos.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		
		// GET ALL SKULLS
		
		// RANDOM CHANCE NUMBER
			// IF CORRECT, GIVE FRAG TO PLAYER
	}
	
}
