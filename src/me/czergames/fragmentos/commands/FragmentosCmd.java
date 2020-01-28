package me.czergames.fragmentos.commands;

import me.czergames.fragmentos.Main;
import me.czergames.fragmentos.mysql.MetodosSQL;
import me.czergames.fragmentos.util.Configs;
import me.czergames.fragmentos.util.CustomSkull;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class FragmentosCmd implements CommandExecutor {
	
	private Configs config() {
		Configs config = new Configs("configuracao.yml");
		config.setPlugin(Main.getPlugin(Main.class));
		
		return config;
	}
	
	
	public static ItemStack getCrystal() {
		ItemStack item = CustomSkull.getSkull("3a5a0715c62122ded65af4eae0969f23f571b0afa50cf93fc9ee2af4c7b34e12");
		ItemMeta itemmeta = item.getItemMeta();
		
		itemmeta.setDisplayName("§bFragmento de Cristal");
		itemmeta.setLore(Arrays.asList(
				"§7\"Pequeno fragmento de um raro cristal encontrado nas",
				"§7profundezas de uma tenebrosa caverna no sul da Rússia.\"",
				"",
				"§fTipo: §bCristal",
				"§fRaridade: §7Comum"
		));
		item.setItemMeta(itemmeta);
		
		return item;
	}
	
	public static ItemStack getRuby() {
		ItemStack item = CustomSkull.getSkull("2530191500c2453624dd937ec125d44f0942cc2b664073e2a366b3fa67a0c897");
		ItemMeta itemmeta = item.getItemMeta();
		
		itemmeta.setDisplayName("§cFragmento de Ruby");
		itemmeta.setLore(Arrays.asList(
				"§7\"Fragmento de Ruby extraído das profundezas da Austrália.",
				"§7Eu não acho que algum dia torne-se mais valioso...\"",
				"",
				"§fTipo: §cRuby",
				"§fRaridade: §aIncomum"
		));
		item.setItemMeta(itemmeta);
		
		return item;
	}
	
	public static ItemStack getVulcanic() {
		ItemStack item = CustomSkull.getSkull("c3687e25c632bce8aa61e0d64c24e694c3eea629ea944f4cf30dcfb4fbce071");
		ItemMeta itemmeta = item.getItemMeta();
		
		itemmeta.setDisplayName("§6Fragmento de Rocha Vulcânica");
		itemmeta.setLore(Arrays.asList(
				"§7\"Fragmento vulcânico, extraído cuidadosamente",
				"§7do vulcão Osorno, no Chile.",
				"§7Cuidado: A rocha ainda se encontra quente!\"",
				"",
				"§fTipo: §6Rocha Vulcânica",
				"§fRaridade: §bRaro"
		));
		item.setItemMeta(itemmeta);
		
		return item;
	}
	
	public static ItemStack getRadioactive() {
		ItemStack item = CustomSkull.getSkull("dc6bacd36ed60f533138e759c425946222b78eda6b616216f6dcc08e90d33e");
		ItemMeta itemmeta = item.getItemMeta();
		
		itemmeta.setDisplayName("§aFragmento de Rocha Radioativa");
		itemmeta.setLore(Arrays.asList(
				"§7\"Pedaço radioativo retirado de Chernobyl.",
				"§7Apesar de ser altamente radioativo, cientistas",
				"§7descobriram uma forma de conter esta radiação!\"",
				"",
				"§fTipo: §aRocha Radioativa",
				"§fRaridade: §bÉpico"
		));
		item.setItemMeta(itemmeta);
		
		return item;
	}
	
	public static ItemStack getMystic() {
		ItemStack item = CustomSkull.getSkull("9c425ea9c4a4cbd123a9ffd4a0ba7480e7c515423dd730fb9fb643c18490107f");
		ItemMeta itemmeta = item.getItemMeta();
		
		itemmeta.setDisplayName("§dFragmento Místico");
		itemmeta.setLore(Arrays.asList(
				"§7\"Fragmento hiperraro! Ninguém sabe de",
				"§7onde veio este pequeno fragmento. Mas",
				"§7dizem ser muito valioso!\"",
				"",
				"§fTipo: §d???",
				"§fRaridade: §5Místico"
		));
		item.setItemMeta(itemmeta);
		
		return item;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.hasPermission("leaffragmentos.admin")) {
				if (args.length > 0) {
					if (args[0].equalsIgnoreCase("give")) {
						if (args.length == 4) {
							if (!p.hasPermission("leaffragmentos.give")) {
								p.sendMessage("§cVocê não tem permissão para executar este comando!");
								return true;
							}
							if (Bukkit.getPlayer(args[1]) != null) {
								if (args[2].equalsIgnoreCase("crystal") || args[2].equalsIgnoreCase("ruby") || args[2].equalsIgnoreCase("vulcanic") || args[2].equalsIgnoreCase("radioactive") || args[2].equalsIgnoreCase("mystic")) {
									Player target = Bukkit.getPlayer(args[1]);
									int count;
									try {
										count = Integer.parseInt(args[3]);
									} catch (NumberFormatException e) {
										p.sendMessage("§cA quantidade inserida não é válida!");
										return true;
									}
									
									if (args[2].equalsIgnoreCase("crystal")) {
										ItemStack item = getCrystal();
										item.setAmount(count);
										target.getInventory().addItem(item);
									}
									if (args[2].equalsIgnoreCase("ruby")) {
										ItemStack item = getRuby();
										item.setAmount(count);
										target.getInventory().addItem(item);
									}
									if (args[2].equalsIgnoreCase("vulcanic")) {
										ItemStack item = getVulcanic();
										item.setAmount(count);
										target.getInventory().addItem(item);
									}
									if (args[2].equalsIgnoreCase("radioactive")) {
										ItemStack item = getRadioactive();
										item.setAmount(count);
										target.getInventory().addItem(item);
									}
									if (args[2].equalsIgnoreCase("mystic")) {
										ItemStack item = getMystic();
										item.setAmount(count);
										target.getInventory().addItem(item);
									}
									p.sendMessage("§aSucesso! Transação feita com sucesso...");
									return true;
								} else {
									p.sendMessage("§cEste tipo de fragmento não foi encontrado!");
									return true;
								}
							} else {
								p.sendMessage("§cEste jogador não existe ou está offline no momento!");
								return true;
							}
						} else {
							p.sendMessage("§cUso incorreto! Utilize §f/fragmentos give <player> <fragmento> <quantidade>");
						}
						return true;
					}
					
					if (args[0].equalsIgnoreCase("reload")) {
						if (!p.hasPermission("leaffragmentos.reload")) {
							p.sendMessage("§cVocê não tem permissão para executar este comando!");
							return true;
						}
						try {
							config().saveConfig();
							config().reloadConfig();
							p.sendMessage("§aConfiguração recarregada com sucesso!");
							return true;
						} catch (Exception e) {
							p.sendMessage("§cHouve um erro ao recarregar a configuração! Verifique o console...");
							return true;
						}
					}
				}
			}
			
			Inventory inv = Bukkit.createInventory(null, (4 * 9), "§a§e§f§0§lBanco de Fragmentos");
			
			ItemStack i1 = getCrystal();
			ItemMeta i1m = i1.getItemMeta();
			ItemStack i2 = getRuby();
			ItemMeta i2m = i2.getItemMeta();
			ItemStack i3 = getVulcanic();
			ItemMeta i3m = i3.getItemMeta();
			ItemStack i4 = getRadioactive();
			ItemMeta i4m = i4.getItemMeta();
			ItemStack i5 = getMystic();
			ItemMeta i5m = i5.getItemMeta();
			
			i1m.setLore(getLore(p, i1));
			i2m.setLore(getLore(p, i2));
			i3m.setLore(getLore(p, i3));
			i4m.setLore(getLore(p, i4));
			i5m.setLore(getLore(p, i5));
			
			i1.setItemMeta(i1m);
			i2.setItemMeta(i2m);
			i3.setItemMeta(i3m);
			i4.setItemMeta(i4m);
			i5.setItemMeta(i5m);
			
			inv.setItem(10, i1);
			inv.setItem(12, i2);
			inv.setItem(14, i3);
			inv.setItem(16, i4);
			inv.setItem(22, i5);
			
			p.openInventory(inv);
		}
		return false;
	}
	
	private List<String> getLore(Player p, ItemStack i) {
		List<String> lore = i.getItemMeta().getLore();
		if (i.getItemMeta().getDisplayName().contains("Cristal")) {
			lore.add("§fVocê possui §e" + MetodosSQL.getFragmentos(p, "crystal") + " §fdestes fragmentos...");
		} else if (i.getItemMeta().getDisplayName().contains("Ruby")) {
			lore.add("§fVocê possui §e" + MetodosSQL.getFragmentos(p, "ruby") + " §fdestes fragmentos...");
		} else if (i.getItemMeta().getDisplayName().contains("Vulcânica")) {
			lore.add("§fVocê possui §e" + MetodosSQL.getFragmentos(p, "vulcanic") + " §fdestes fragmentos...");
		} else if (i.getItemMeta().getDisplayName().contains("Radioativa")) {
			lore.add("§fVocê possui §e" + MetodosSQL.getFragmentos(p, "radioactive") + " §fdestes fragmentos...");
		} else if (i.getItemMeta().getDisplayName().contains("Místico")) {
			lore.add("§fVocê possui §e" + MetodosSQL.getFragmentos(p, "mystic") + " §fdestes fragmentos...");
		}
		lore.add("");
		lore.add("§eClique esquerdo para retirar um");
		lore.add("§eShift + Clique esquerdo para retirar todos");
		lore.add("§6Clique direito para depositar um");
		lore.add("§6Shift + Clique direito para depositar todos");
		return lore;
	}
	
}