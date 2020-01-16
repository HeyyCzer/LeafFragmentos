package me.czergames.fragmentos.listeners;

import me.czergames.fragmentos.commands.FragmentosCmd;
import me.czergames.fragmentos.mysql.MetodosSQL;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		
		if (event.getInventory().getTitle().equals("§a§e§f§0§lBanco de Fragmentos")) {
			event.setCancelled(true);
			
			if (event.getSlot() == 10) {
				if (event.getClick().equals(ClickType.LEFT)) {
					if (MetodosSQL.getFragmentos(p, "crystal") >= 1) {
						p.getInventory().addItem(FragmentosCmd.getCrystal());
						MetodosSQL.removeFrag(p, "crystal", 1);
						
						p.sendMessage("§aVocê retirou 1 de seus §fFragmentos de Cristal §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_LEFT)) {
					if (MetodosSQL.getFragmentos(p, "crystal") >= 1) {
						int count = MetodosSQL.getFragmentos(p, "crystal");
						MetodosSQL.setFragCount(p, "crystal", 0);
						
						ItemStack crystal = FragmentosCmd.getCrystal();
						crystal.setAmount(count);
						
						p.getInventory().addItem(crystal);
						
						p.sendMessage("§aVocê retirou todos os seus §fFragmentos de Cristal §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				
				if (event.getClick().equals(ClickType.RIGHT)) {
					if (p.getInventory().contains(FragmentosCmd.getCrystal())) {
						p.getInventory().remove(FragmentosCmd.getCrystal());
						MetodosSQL.addFrag(p, "crystal", 1);
						
						p.sendMessage("§aVocê depositou 1 de seus §fFragmentos de Cristal §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
					if (p.getInventory().contains(FragmentosCmd.getCrystal())) {
						while (p.getInventory().contains(FragmentosCmd.getCrystal())) {
							p.getInventory().remove(FragmentosCmd.getCrystal());
							MetodosSQL.addFrag(p, "crystal", 1);
						}
						p.sendMessage("§aVocê depositou todos os seus §fFragmentos de Cristal §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
			}
			if (event.getSlot() == 12) {
				if (event.getClick().equals(ClickType.LEFT)) {
					if (MetodosSQL.getFragmentos(p, "crystal") >= 1) {
						p.getInventory().addItem(FragmentosCmd.getCrystal());
						MetodosSQL.removeFrag(p, "crystal", 1);
						
						p.sendMessage("§aVocê retirou 1 de seus §fFragmentos de Ruby §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_LEFT)) {
					if (MetodosSQL.getFragmentos(p, "crystal") >= 1) {
						int count = MetodosSQL.getFragmentos(p, "crystal");
						MetodosSQL.setFragCount(p, "crystal", 0);
						
						ItemStack crystal = FragmentosCmd.getCrystal();
						crystal.setAmount(count);
						
						p.getInventory().addItem(crystal);
						
						p.sendMessage("§aVocê retirou todos os seus §fFragmentos de Ruby §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				
				if (event.getClick().equals(ClickType.RIGHT)) {
					if (p.getInventory().contains(FragmentosCmd.getCrystal())) {
						p.getInventory().remove(FragmentosCmd.getCrystal());
						MetodosSQL.addFrag(p, "crystal", 1);
						
						p.sendMessage("§aVocê depositou 1 de seus §fFragmentos de Ruby §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
					if (p.getInventory().contains(FragmentosCmd.getCrystal())) {
						while (p.getInventory().contains(FragmentosCmd.getCrystal())) {
							p.getInventory().remove(FragmentosCmd.getCrystal());
							MetodosSQL.addFrag(p, "crystal", 1);
						}
						p.sendMessage("§aVocê depositou todos os seus §fFragmentos de Ruby §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
			}
			if (event.getSlot() == 14) {
				if (event.getClick().equals(ClickType.LEFT)) {
					if (MetodosSQL.getFragmentos(p, "crystal") >= 1) {
						p.getInventory().addItem(FragmentosCmd.getCrystal());
						MetodosSQL.removeFrag(p, "crystal", 1);
						
						p.sendMessage("§aVocê retirou 1 de seus §fRochas Vulcanicas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_LEFT)) {
					if (MetodosSQL.getFragmentos(p, "crystal") >= 1) {
						int count = MetodosSQL.getFragmentos(p, "crystal");
						MetodosSQL.setFragCount(p, "crystal", 0);
						
						ItemStack crystal = FragmentosCmd.getCrystal();
						crystal.setAmount(count);
						
						p.getInventory().addItem(crystal);
						
						p.sendMessage("§aVocê retirou todas as suas §fRochas Vulcanicas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				
				if (event.getClick().equals(ClickType.RIGHT)) {
					if (p.getInventory().contains(FragmentosCmd.getCrystal())) {
						p.getInventory().remove(FragmentosCmd.getCrystal());
						MetodosSQL.addFrag(p, "crystal", 1);
						
						p.sendMessage("§aVocê depositou 1 de seus §fRochas Vulcanicas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
					if (p.getInventory().contains(FragmentosCmd.getCrystal())) {
						while (p.getInventory().contains(FragmentosCmd.getCrystal())) {
							p.getInventory().remove(FragmentosCmd.getCrystal());
							MetodosSQL.addFrag(p, "crystal", 1);
						}
						p.sendMessage("§aVocê depositou todas as suas §fRochas Vulcanicas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
			}
			if (event.getSlot() == 16) {
				if (event.getClick().equals(ClickType.LEFT)) {
					if (MetodosSQL.getFragmentos(p, "crystal") >= 1) {
						p.getInventory().addItem(FragmentosCmd.getCrystal());
						MetodosSQL.removeFrag(p, "crystal", 1);
						
						p.sendMessage("§aVocê retirou 1 de suas §fRochas Radioativas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_LEFT)) {
					if (MetodosSQL.getFragmentos(p, "crystal") >= 1) {
						int count = MetodosSQL.getFragmentos(p, "crystal");
						MetodosSQL.setFragCount(p, "crystal", 0);
						
						ItemStack crystal = FragmentosCmd.getCrystal();
						crystal.setAmount(count);
						
						p.getInventory().addItem(crystal);
						
						p.sendMessage("§aVocê retirou todas as suas §fRochas Radioativas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				
				if (event.getClick().equals(ClickType.RIGHT)) {
					if (p.getInventory().contains(FragmentosCmd.getCrystal())) {
						p.getInventory().remove(FragmentosCmd.getCrystal());
						MetodosSQL.addFrag(p, "crystal", 1);
						
						p.sendMessage("§aVocê depositou 1 de suas §fRochas Radioativas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
					if (p.getInventory().contains(FragmentosCmd.getCrystal())) {
						while (p.getInventory().contains(FragmentosCmd.getCrystal())) {
							p.getInventory().remove(FragmentosCmd.getCrystal());
							MetodosSQL.addFrag(p, "crystal", 1);
						}
						p.sendMessage("§aVocê depositou todas as suas §fRochas Radioativas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
			}
			if (event.getSlot() == 22) {
				if (event.getClick().equals(ClickType.LEFT)) {
					if (MetodosSQL.getFragmentos(p, "crystal") >= 1) {
						p.getInventory().addItem(FragmentosCmd.getCrystal());
						MetodosSQL.removeFrag(p, "crystal", 1);
						
						p.sendMessage("§aVocê retirou 1 de seus §fFragmentos Místicos §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_LEFT)) {
					if (MetodosSQL.getFragmentos(p, "crystal") >= 1) {
						int count = MetodosSQL.getFragmentos(p, "crystal");
						MetodosSQL.setFragCount(p, "crystal", 0);
						
						ItemStack crystal = FragmentosCmd.getCrystal();
						crystal.setAmount(count);
						
						p.getInventory().addItem(crystal);
						
						p.sendMessage("§aVocê retirou todos os seus §fFragmentos Místicos §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				
				if (event.getClick().equals(ClickType.RIGHT)) {
					if (p.getInventory().contains(FragmentosCmd.getCrystal())) {
						p.getInventory().remove(FragmentosCmd.getCrystal());
						MetodosSQL.addFrag(p, "mystic", 1);
						
						p.sendMessage("§aVocê depositou 1 de seus §fFragmentos Místicos §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
					if (p.getInventory().contains(FragmentosCmd.getCrystal())) {
						while (p.getInventory().contains(FragmentosCmd.getCrystal())) {
							p.getInventory().remove(FragmentosCmd.getCrystal());
							MetodosSQL.addFrag(p, "mystic", 1);
						}
						p.sendMessage("§aVocê depositou todos os seus §fFragmentos Místicos §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
			}
		}
	}
	
}
