package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {

		private static String driverName;
		private static String dbURL;
		static{
			
			driverName = "org.sqlite.JDBC";
			dbURL="jdbc:sqlite:\\E:/old eclipse/GuitarSale/WebContent/DB/guitarsale.db";
		}
		public static Connection open(){
			try {
					Class.forName(driverName);
				try {
					return DriverManager.getConnection(dbURL);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return null;
		}
		public static void close(Connection Conn){
			if(Conn != null){
				try {
					Conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


