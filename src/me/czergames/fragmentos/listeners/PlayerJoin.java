package me.czergames.fragmentos.listeners;

import me.czergames.fragmentos.mysql.MetodosSQL;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		
		MetodosSQL.registerPlayer(p);
	}

}
