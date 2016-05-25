package DBconnection;

import java.util.List;

import guitar.m.Guitar;

public interface aduGuitar {
	
	public void addGuitar(String serialNumber,Double price, String builder, String type, String backWood, String topWood);
	
	public void deleteGuitar(String serialNumber);	
	
	public void updateGuitar(String serialNumber,Double price, String builder, String type, String backWood, String topWood);
	
	public List<Guitar> guitars();
	
	

}
