package me.czergames.fragmentos.mysql;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetodosSQL extends ConectarSQL {
	
	public static int getFragmentos(Player p, String type) {
		PreparedStatement stm;
		try {
			stm = con.prepareStatement("SELECT * FROM `user_frags` WHERE `namelc` = ?");
			stm.setString(1, p.getName().toLowerCase());
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				return rs.getInt(type);
			}
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static int getTotalFrags(Player p) {
		PreparedStatement stm;
		try {
			stm = con.prepareStatement("SELECT * FROM `user_frags` WHERE `namelc` = ?");
			stm.setString(1, p.getName().toLowerCase());
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				int f1 = rs.getInt("crystal");
				int f2 = rs.getInt("ruby");
				int f3 = rs.getInt("vulcanic");
				int f4 = rs.getInt("radioactive");
				int f5 = rs.getInt("mystic");
				
				return f1 + f2 + f3 + f4 + f5;
			}
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void setFragCount(Player p, String type, int count) {
		PreparedStatement stm;
		try {
			stm = con.prepareStatement("UPDATE `user_frags` SET `" + type + "` = ? WHERE `namelc` = ?");
			stm.setInt(1, count);
			stm.setString(2, p.getName().toLowerCase());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void addFrag(Player p, String type, int count) {
		int pcount = getFragmentos(p, type);
		setFragCount(p, type, pcount + count);
	}
	public static void removeFrag(Player p, String type, int count) {
		int pcount = getFragmentos(p, type);
		setFragCount(p, type, pcount - count);
	}
}
