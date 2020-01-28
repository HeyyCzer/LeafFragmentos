package me.czergames.fragmentos.listeners;

import me.czergames.fragmentos.Main;
import me.czergames.fragmentos.mysql.MetodosSQL;
import me.czergames.fragmentos.util.Configs;
import me.czergames.fragmentos.util.Title;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class BlockBreak implements Listener {
	
	private Configs config() {
		Configs config = new Configs("configuracao.yml");
		config.setPlugin(Main.getPlugin(Main.class));
		
		return config;
	}
	
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		
		if(event.getBlock().getType() != Material.LAPIS_ORE && event.getBlock().getType() != Material.STONE &&
				event.getBlock().getType() != Material.REDSTONE_ORE && event.getBlock().getType() != Material.REDSTONE_BLOCK &&
				event.getBlock().getType() != Material.DIAMOND_ORE & event.getBlock().getType() != Material.DIAMOND_BLOCK) return;
		
		Random random = new Random();
		double r = random.nextDouble();
		
		if(r <= ((config().getDouble("chances.mystic") / 100) / 50)) { // MYSTIC
			MetodosSQL.addFrag(p, "mystic", 1);
			p.sendMessage("§5+§d1 §fFragmento Místico");
			for(Player i : Bukkit.getOnlinePlayers()) {
				Title.sendTitle(i, "§d§l" + p.getName(), "§fencontrou um §dFragmento Místico §fminerando!", 20, 60, 20);
			}
		}else if(r <= ((config().getDouble("chances.radioactive") / 100) / 25)) { // RADIOACTIVE
			MetodosSQL.addFrag(p, "radioactive", 1);
			p.sendMessage("§6+§e1 §7Fragmento de Rocha Radioativa");
		}
		else if(r <= ((config().getDouble("chances.vulcanic") / 100) / 25)) { // VULCANIC
			MetodosSQL.addFrag(p, "vulcanic", 1);
			p.sendMessage("§6+§e1 §7Fragmento de Rocha Vulcânica");
		}
		else if(r <= ((config().getDouble("chances.ruby") / 100) / 25)) { // RUBY
			MetodosSQL.addFrag(p, "ruby", 1);
			p.sendMessage("§6+§e1 §7Fragmento de Ruby");
		}
		else if(r <= ((config().getDouble("chances.crystal") / 100) / 25)) { // CRYSTAL
			MetodosSQL.addFrag(p, "crystal", 1);
			p.sendMessage("§6+§e1 §7Fragmento de Cristal");
		}
	}
	
}
