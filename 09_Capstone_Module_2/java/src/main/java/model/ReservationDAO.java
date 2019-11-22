package model;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO {
	
	public List<Reservation> getReservations(String campground, LocalDate startDate, LocalDate endDate);
	
//	public boolean checkIfAvailableBySiteId(Long siteId, LocalDate startDate, LocalDate endDate);

	public Reservation createNewReservation(String reservationName, Long longSiteId, LocalDate startDate,
			LocalDate endDate);
	
	
}
