package entites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static String dburl="jdbc:mysql://localhost:3306/swing";
	private static String dbuser="root";
	private static String dbpass="";
	public static Connection connexion=null;
	
	public static void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connexion=DriverManager.getConnection(dburl,dbuser,dbpass);
		} catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public static void Disconnect() {
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
