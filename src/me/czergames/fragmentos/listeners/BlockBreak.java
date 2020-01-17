package me.czergames.fragmentos.listeners;

import me.czergames.fragmentos.commands.FragmentosCmd;
import me.czergames.fragmentos.mysql.MetodosSQL;
import me.czergames.fragmentos.util.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class BlockBreak implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		
		Random random = new Random();
		double r = random.nextDouble();
		
		if(r <= (0.01 / 100)) { // MYSTIC
			MetodosSQL.addFrag(p, "mystic", 1);
			p.sendMessage("§5+§d1 §fFragmento Místico");
			for(Player i : Bukkit.getOnlinePlayers()) {
				Title.sendTitle(i, "§d§l" + p.getName(), "§fencontrou um §dFragmento Místico §fminerando!", 20, 60, 20);
			}
		}else if(r <= (0.05 / 100)) { // RADIOACTIVE
			MetodosSQL.addFrag(p, "radioactive", 1);
			p.sendMessage("§6+§e1 §7Fragmento de Rocha Radioativa");
		}
		else if(r <= (0.08 / 100)) { // VULCANIC
			MetodosSQL.addFrag(p, "vulcanic", 1);
			p.sendMessage("§6+§e1 §7Fragmento de Rocha Vulcânica");
		}
		else if(r <= (0.15 / 100)) { // RUBY
			MetodosSQL.addFrag(p, "ruby", 1);
			p.sendMessage("§6+§e1 §7Fragmento de Ruby");
		}
		else if(r <= (0.21 / 100)) { // CRYSTAL
			MetodosSQL.addFrag(p, "crystal", 1);
			p.sendMessage("§6+§e1 §7Fragmento de Cristal");
		}
	}
	
}
