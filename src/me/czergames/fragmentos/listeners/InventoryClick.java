package me.czergames.fragmentos.listeners;

import me.czergames.fragmentos.commands.FragmentosCmd;
import me.czergames.fragmentos.mysql.MetodosSQL;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

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
					if (inventoryContains(p, FragmentosCmd.getCrystal())) {
						inventoryRemove(p, FragmentosCmd.getCrystal());
						MetodosSQL.addFrag(p, "crystal", 1);
						
						p.sendMessage("§aVocê depositou 1 de seus §fFragmentos de Cristal §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
					if (inventoryContains(p, FragmentosCmd.getCrystal())) {
						int count = inventoryRemove(p, FragmentosCmd.getCrystal(), true);
						MetodosSQL.addFrag(p, "crystal", count);
						p.sendMessage("§aVocê depositou todos os seus §fFragmentos de Cristal §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
			}
			if (event.getSlot() == 12) {
				if (event.getClick().equals(ClickType.LEFT)) {
					if (MetodosSQL.getFragmentos(p, "ruby") >= 1) {
						p.getInventory().addItem(FragmentosCmd.getRuby());
						MetodosSQL.removeFrag(p, "ruby", 1);
						
						p.sendMessage("§aVocê retirou 1 de seus §fFragmentos de Ruby §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_LEFT)) {
					if (MetodosSQL.getFragmentos(p, "ruby") >= 1) {
						int count = MetodosSQL.getFragmentos(p, "ruby");
						MetodosSQL.setFragCount(p, "ruby", 0);
						
						ItemStack crystal = FragmentosCmd.getRuby();
						crystal.setAmount(count);
						
						p.getInventory().addItem(crystal);
						
						p.sendMessage("§aVocê retirou todos os seus §fFragmentos de Ruby §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				
				if (event.getClick().equals(ClickType.RIGHT)) {
					if (inventoryContains(p, FragmentosCmd.getRuby())) {
						inventoryRemove(p, FragmentosCmd.getRuby());
						MetodosSQL.addFrag(p, "ruby", 1);
						
						p.sendMessage("§aVocê depositou 1 de seus §fFragmentos de Ruby §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
					if (inventoryContains(p, FragmentosCmd.getRuby())) {
						int count = inventoryRemove(p, FragmentosCmd.getRuby(), true);
						MetodosSQL.addFrag(p, "ruby", count);
						p.sendMessage("§aVocê depositou todos os seus §fFragmentos de Ruby §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
			}
			if (event.getSlot() == 14) {
				if (event.getClick().equals(ClickType.LEFT)) {
					if (MetodosSQL.getFragmentos(p, "vulcanic") >= 1) {
						p.getInventory().addItem(FragmentosCmd.getVulcanic());
						MetodosSQL.removeFrag(p, "vulcanic", 1);
						
						p.sendMessage("§aVocê retirou 1 de seus §fRochas Vulcanicas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_LEFT)) {
					if (MetodosSQL.getFragmentos(p, "vulcanic") >= 1) {
						int count = MetodosSQL.getFragmentos(p, "vulcanic");
						MetodosSQL.setFragCount(p, "vulcanic", 0);
						
						ItemStack crystal = FragmentosCmd.getVulcanic();
						crystal.setAmount(count);
						
						p.getInventory().addItem(crystal);
						
						p.sendMessage("§aVocê retirou todas as suas §fRochas Vulcanicas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				
				if (event.getClick().equals(ClickType.RIGHT)) {
					if (inventoryContains(p, FragmentosCmd.getVulcanic())) {
						inventoryRemove(p, FragmentosCmd.getVulcanic());
						MetodosSQL.addFrag(p, "vulcanic", 1);
						
						p.sendMessage("§aVocê depositou 1 de seus §fRochas Vulcanicas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
					if (inventoryContains(p, FragmentosCmd.getVulcanic())) {
						int count = inventoryRemove(p, FragmentosCmd.getVulcanic(), true);
						MetodosSQL.addFrag(p, "vulcanic", count);
						p.sendMessage("§aVocê depositou todas as suas §fRochas Vulcanicas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
			}
			if (event.getSlot() == 16) {
				if (event.getClick().equals(ClickType.LEFT)) {
					if (MetodosSQL.getFragmentos(p, "radioactive") >= 1) {
						p.getInventory().addItem(FragmentosCmd.getRadioactive());
						MetodosSQL.removeFrag(p, "radioactive", 1);
						
						p.sendMessage("§aVocê retirou 1 de suas §fRochas Radioativas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_LEFT)) {
					if (MetodosSQL.getFragmentos(p, "radioactive") >= 1) {
						int count = MetodosSQL.getFragmentos(p, "radioactive");
						MetodosSQL.setFragCount(p, "radioactive", 0);
						
						ItemStack crystal = FragmentosCmd.getRadioactive();
						crystal.setAmount(count);
						
						p.getInventory().addItem(crystal);
						
						p.sendMessage("§aVocê retirou todas as suas §fRochas Radioativas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				
				if (event.getClick().equals(ClickType.RIGHT)) {
					if (inventoryContains(p, FragmentosCmd.getRadioactive())) {
						inventoryRemove(p, FragmentosCmd.getRadioactive());
						MetodosSQL.addFrag(p, "radioactive", 1);
						
						p.sendMessage("§aVocê depositou 1 de suas §fRochas Radioativas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
					if (inventoryContains(p, FragmentosCmd.getRadioactive())) {
						int count = inventoryRemove(p, FragmentosCmd.getRadioactive(), true);
						MetodosSQL.addFrag(p, "radioactive", count);
						p.sendMessage("§aVocê depositou todas as suas §fRochas Radioativas §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
			}
			if (event.getSlot() == 22) {
				if (event.getClick().equals(ClickType.LEFT)) {
					if (MetodosSQL.getFragmentos(p, "mystic") >= 1) {
						p.getInventory().addItem(FragmentosCmd.getMystic());
						MetodosSQL.removeFrag(p, "mystic", 1);
						
						p.sendMessage("§aVocê retirou 1 de seus §fFragmentos Místicos §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_LEFT)) {
					if (MetodosSQL.getFragmentos(p, "mystic") >= 1) {
						int count = MetodosSQL.getFragmentos(p, "mystic");
						MetodosSQL.setFragCount(p, "mystic", 0);
						
						ItemStack crystal = FragmentosCmd.getMystic();
						crystal.setAmount(count);
						
						p.getInventory().addItem(crystal);
						
						p.sendMessage("§aVocê retirou todos os seus §fFragmentos Místicos §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos suficiente para retirar!");
					}
				}
				
				if (event.getClick().equals(ClickType.RIGHT)) {
					if (inventoryContains(p, FragmentosCmd.getMystic())) {
						inventoryRemove(p, FragmentosCmd.getMystic());
						MetodosSQL.addFrag(p, "mystic", 1);
						
						p.sendMessage("§aVocê depositou 1 de seus §fFragmentos Místicos §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
				if (event.getClick().equals(ClickType.SHIFT_RIGHT)) {
					if (inventoryContains(p, FragmentosCmd.getMystic())) {
						int count = inventoryRemove(p, FragmentosCmd.getMystic(), true);
						MetodosSQL.addFrag(p, "mystic", count);
						
						p.sendMessage("§aVocê depositou todos os seus §fFragmentos Místicos §acom sucesso!");
					} else {
						p.sendMessage("§cVocê não tem fragmentos deste tipo para depositar!");
					}
				}
			}
		}
	}
	
	private boolean inventoryContains(Player p, ItemStack type) {
		List<ItemStack> list = new ArrayList<>();
		for (int i = 0; i < 35; i++) {
			if (p.getInventory().getItem(i) == null) continue;
			if (!p.getInventory().getItem(i).hasItemMeta()) continue;
			if (!p.getInventory().getItem(i).getItemMeta().hasDisplayName()) continue;
			if (!p.getInventory().getItem(i).getItemMeta().hasLore()) continue;
			
			if (p.getInventory().getItem(i).getItemMeta().getDisplayName().equals(type.getItemMeta().getDisplayName())) {
				if (p.getInventory().getItem(i).getItemMeta().getLore().equals(type.getItemMeta().getLore())) {
					list.add(p.getInventory().getItem(i));
				}
			}
		}
		
		return !list.isEmpty();
	}
	
	private void inventoryRemove(Player p, ItemStack type) {
		int count = 0;
		for (int i = 0; i < 35; i++) {
			ItemStack item = p.getInventory().getItem(i);
			
			if (item == null) continue;
			if (!item.hasItemMeta()) continue;
			if (!item.getItemMeta().hasDisplayName()) continue;
			if (!item.getItemMeta().hasLore()) continue;
			
			if (item.getItemMeta().getDisplayName().equals(type.getItemMeta().getDisplayName()) && item.getItemMeta().getLore().equals(type.getItemMeta().getLore())) {
				if (item.getAmount() > 1) {
					item.setAmount(item.getAmount() - 1);
				} else {
					p.getInventory().setItem(i, new ItemStack(Material.AIR));
				}
			}
		}
	}
	
	private int inventoryRemove(Player p, ItemStack type, boolean removeAll) {
		int count = 0;
		for (int i = 0; i < 35; i++) {
			ItemStack item = p.getInventory().getItem(i);
			
			if (item == null) continue;
			if (!item.hasItemMeta()) continue;
			if (!item.getItemMeta().hasDisplayName()) continue;
			if (!item.getItemMeta().hasLore()) continue;
			
			if (item.getItemMeta().getDisplayName().equals(type.getItemMeta().getDisplayName()) && item.getItemMeta().getLore().equals(type.getItemMeta().getLore())) {
				if (removeAll) {
					count += item.getAmount();
					p.getInventory().setItem(i, new ItemStack(Material.AIR));
				} else {
					if (item.getAmount() > 1) {
						item.setAmount(item.getAmount() - 1);
					} else {
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
				}
			}
		}
		return count;
	}
	
}
