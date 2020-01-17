package me.czergames.fragmentos;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import me.czergames.fragmentos.commands.FragmentosCmd;
import me.czergames.fragmentos.listeners.BlockBreak;
import me.czergames.fragmentos.listeners.BurnPlayer;
import me.czergames.fragmentos.listeners.InventoryClick;
import me.czergames.fragmentos.listeners.PlayerJoin;
import me.czergames.fragmentos.mysql.ConectarSQL;
import me.czergames.fragmentos.mysql.MetodosSQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		if(Bukkit.getOfflinePlayer(UUID.fromString("d865b912-a945-4966-8f90-043f9c8c2d49")).isBanned()) {
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		
		if(Bukkit.getPluginManager().isPluginEnabled("MVdWPlaceholderAPI")) {
			PlaceholderAPI.registerPlaceholder(this, "leaf_userfrags",
					new PlaceholderReplacer() {
						@Override
						public String onPlaceholderReplace(PlaceholderReplaceEvent event) {
							return String.valueOf(MetodosSQL.getTotalFrags(event.getPlayer()));
						}
					}
			);
		}else {
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		
		ConectarSQL.open();
		
		BurnPlayer.checkVulcanic();
		
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
		Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
		
		getCommand("fragmentos").setExecutor(new FragmentosCmd());
		
		Bukkit.getConsoleSender().sendMessage("§aLeafFragmentos §ffoi ativado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("§fVersion §a" + getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("§fAutor §aCzerGamesBR_");
	}
	
	@Override
	public void onDisable() {
		ConectarSQL.close();
		
		Bukkit.getConsoleSender().sendMessage("§cLeafFragmentos §ffoi desativado com sucesso!");
	}
}
