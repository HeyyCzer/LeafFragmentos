package me.czergames.fragmentos.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConectarSQL {
	
	public static Connection con;
	
	public static void open() {
		if (isOpen()) return;
		try {
			String url = "jdbc:mysql://HOST:PORT/DATABASE";
			url = url.replaceAll("HOST", "142.44.170.38");
			url = url.replaceAll("PORT", "3306");
			url = url.replaceAll("DATABASE", "s345_vitor");
			
			con = DriverManager.getConnection(url, "u345_tRAyu1Eh1w", "04x2GKecwb4NoZrI6sy6G61z");
			createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close() {
		if (isClosed()) return;
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean isOpen() {
		return con != null;
	}
	private static boolean isClosed() {
		return con == null;
	}
	
	private static void createTable() {
		PreparedStatement stm;
		try {
			stm = con.prepareStatement("CREATE TABLE IF NOT EXISTS `user_frags`(`name` VARCHAR(50), `namelc` VARCHAR(50), `crystal` INT, `ruby` INT, `vulcanic` INT, `radioactive` INT, `mystic` INT)");
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}