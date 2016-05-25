package DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guitar.m.Guitar;

public class Implement implements aduGuitar{
	//≤Â»Î
	public void addGuitar(String serialNumber, String price,String builder,  String type, String backWood,String topWood) {
		Connection Conn = DBconn.open();
		String sql = "insert into Guitar(serialNumber,price,builder,type,backWood,topWood) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			pstmt.setString(2, price);
			pstmt.setString(3, builder);
			pstmt.setString(4, type);
			pstmt.setString(5, backWood);
			pstmt.setString(6, topWood);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBconn.close(Conn);
		}
	}
		//≤È—Ø
	public List<Guitar> guitars() {
		Connection Conn = DBconn.open();
		String sql = "select * from Guitar";
		List<Guitar> inventory = new ArrayList<Guitar>();
		
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Guitar guitar = new Guitar();
				guitar.setSerialNumber(rs.getString(1));
				guitar.setPrice(rs.getString(2));
				guitar.setBuilder(rs.getString(3));
				guitar.setType(rs.getString(4));
				guitar.setBackwood(rs.getString(5));
				guitar.setTopwood(rs.getString(6));
				
				inventory.add(guitar);
			}
			return inventory;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBconn.close(Conn);
		}
		return null;
	}
		@Override
		public void addGuitar(String serialNumber, Double price, String builder, String type, String backWood,
				String topWood) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void deleteGuitar(String serialNumber) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void updateGuitar(String serialNumber, Double price, String builder, String type, String backWood,
				String topWood) {
			// TODO Auto-generated method stub
			
		}

}
