package model;

import java.time.LocalDate;
import java.util.List;

public interface SiteDAO {
	
	public List<Site> getSitesByCampgroundName(String userCampground);
	
	public List<Site> getAllAvailableReservations();
	
	public List<Site> availableSites(String campground, LocalDate startDate, LocalDate endDate);

}
