package model;

import java.util.List;

public interface CampgroundDAO {

	public List<Campground> getAllCampgrounds();

	public List<Campground> getCampgrounds(String campSearch);

	public List<Campground> searchCampgroundByName(String nameSearch);
	
	public List<Campground> getCampgroundByParkId(Long parkId);

}
