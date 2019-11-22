package jdbc;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import model.Campground;
import model.Reservation;
import model.ReservationDAO;
import model.Site;

public class JDBCReservationDAO implements ReservationDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	
	public List<Reservation> getReservations(String campground, LocalDate startDate, LocalDate endDate) {
		
		List<Reservation> reservationList = new ArrayList<Reservation>();

		String sqlString = "SELECT * FROM reservation r JOIN site s ON s.site_id=r.site_id "
				+ "JOIN site s ON c.campground_id=s.campground_id"
				+ "  WHERE c.name LIKE ? AND from_date=? AND end_date=?";
		Date dateStartDate = Date.valueOf(startDate);
		Date dateEndDate = Date.valueOf(endDate);
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlString, "%" + campground + "%", dateStartDate, dateEndDate);
		while (results.next()) {
			Reservation reservation = new Reservation();
			Long resId = results.getLong("reservation_id");
			reservation.setId(resId);
			Long siteId = results.getLong("site_id");
			reservation.setSiteId(siteId);
			String tempName = results.getString("name");
			reservation.setName(tempName);
			LocalDate fromDate = results.getDate("from_date").toLocalDate();
			reservation.setFromDate(fromDate);
			LocalDate toDate = results.getDate("to_date").toLocalDate();
			reservation.setToDate(toDate);
			LocalDate createDate = results.getDate("create_date").toLocalDate();
			reservation.setCreateDate(createDate);
			reservationList.add(reservation);
		}
		return reservationList;
	}
	public Reservation createNewReservation(String reservationName, Long longSiteId, LocalDate startDate,
			LocalDate endDate) {
		Reservation reservation = new Reservation();
		String sqlString = "insert into reservation (reservation_id, site_id, name, from_date, to_date, create_date) values (?, ?, ?, ?, ?, ?)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlString);
		while (results.next()) {
			Long resId = results.getLong("reservation_id");
			reservation.setId(resId);
			Long siteId = results.getLong("site_id");
			reservation.setSiteId(siteId);
			String tempName = results.getString("name");
			reservation.setName(tempName);
			LocalDate fromDate = results.getDate("from_date").toLocalDate();
			reservation.setFromDate(fromDate);
			LocalDate toDate = results.getDate("to_date").toLocalDate();
			reservation.setToDate(toDate);
			LocalDate createDate = results.getDate("create_date").toLocalDate();
			reservation.setCreateDate(createDate);
		}
		return reservation;
	}
	
	public boolean checkIfAvailableBySiteId(Long siteId, LocalDate startDate, LocalDate endDate) {
		
		List <Reservation> reservationList = new ArrayList <Reservation>();
		
		String sqlString = "select * from reservation where site_id = ?";
		boolean isAvailable = true, badFrom = false, badTo = false, badResFrom = false, badResTo = false;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlString, siteId);
		while (results.next()) {
			Reservation reservation = new Reservation();
			Long resId = results.getLong("reservation_id");
			reservation.setId(resId);
			Long sideID = results.getLong("site_id");
			reservation.setSiteId(siteId);
			String tempName = results.getString("name");
			reservation.setName(tempName);
			LocalDate fromDate = results.getDate("from_date").toLocalDate();
			reservation.setFromDate(fromDate);
			LocalDate toDate = results.getDate("to_date").toLocalDate();
			reservation.setToDate(toDate);
			LocalDate createDate = results.getDate("create_date").toLocalDate();
			reservation.setCreateDate(createDate);
			reservationList.add(reservation);
		}

	    for (Reservation res : reservationList) {
	        badFrom = res.getFromDate().compareTo(startDate) <= 0 && res.getToDate().compareTo(startDate) >= 0;
	        badTo = res.getFromDate().compareTo(endDate) <= 0 && res.getToDate().compareTo(endDate) >= 0;
	        badResFrom = startDate.compareTo(res.getFromDate()) <= 0 && endDate.compareTo(res.getFromDate()) >= 0;
	        badResTo = startDate.compareTo(res.getToDate()) <= 0 && endDate.compareTo(res.getToDate()) >= 0;
	        if (badFrom || badTo || badResFrom || badResTo)
	            isAvailable = false;
	    }
	    return isAvailable;
	}
	
}
