package model;

import java.util.List;

public interface ParkDAO {
	
	public List <Park> getAllParks();
	
	public Park getParkByName(String name);

}
