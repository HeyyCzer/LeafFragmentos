package me.czergames.fragmentos.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConectarSQL {
	
	public static Connection con;
	
	public static void open() {
		if (isOpen()) return;
		//  server_1309  L6oD5tfGRTul 144.217.10.229
		try {
			String url = "jdbc:mysql://HOST:PORT/DATABASE";
			url = url.replaceAll("HOST", "144.217.10.229");
			url = url.replaceAll("PORT", "3306");
			url = url.replaceAll("DATABASE", "server_1309");
			
			con = DriverManager.getConnection(url, "server_1309", "L6oD5tfGRTuI");
			
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