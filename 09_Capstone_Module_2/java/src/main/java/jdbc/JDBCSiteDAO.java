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
import model.Site;
import model.SiteDAO;

public class JDBCSiteDAO implements SiteDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	
	public List<Site> getAllAvailableReservations() {
		
		List<Site> reservationList = new ArrayList<Site>();

		String sqlString = "SELECT site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities FROM site WHERE campground_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlString);
		while (results.next()) {
			Site site = new Site();
			Long siteId = results.getLong("site_id");
			site.setId(siteId);
			Long campgroundId = results.getLong("campground_Id");
			site.setId(campgroundId);
			Long siteNumber = results.getLong("site_number");
			site.setId(siteNumber);
			Long maxOccupancy = results.getLong("max_occupancy");
			site.setId(maxOccupancy);
		}

		return reservationList;
	}
	
	public List<Site> getSitesByCampgroundName(String userCampground) {
	
	List<Site> siteList = new ArrayList<Site>();

	String sqlString = "SELECT site_number, max_occupancy, accessible, max_rv_length, utilities, campground.daily_fee FROM site " + 
			"inner join campground " + 
			"on campground.campground_id = site.campground_id " +
			"inner join reservation " +
			"on reservation.site_id = site.site_id " +
			 "where campground.name = ? and from_date > NOW() LIMIT 5 ";
	String fuzzyString = "%" + userCampground + "%";
	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlString, userCampground);
	while (results.next()) {
	Site site = new Site();
		Long siteNumber = results.getLong("site_number");
		site.setSiteNumber(siteNumber);
		Long maxOccupancy = results.getLong("max_occupancy");
		site.setMaxOccupancy(maxOccupancy);
		boolean accessible = results.getBoolean("accessible");
		site.setAccessible(accessible);
		Long maxRvLength = results.getLong("max_rv_length");
		site.setMaxRVLength(maxRvLength);
		boolean utilities = results.getBoolean("utilities");
		site.setUtilities(utilities);
	//	BigDecimal dailyFee = results.getBigDecimal("campground.daily_fee");
	//	site.setDailyFee(dailyFee);
		siteList.add(site);
	}
	return siteList;
}
	
	public List<Site> availableSites(String campground, LocalDate startDate, LocalDate endDate){
		List<Site> site = new ArrayList<>();
		
		String sqlGetAllReservations = "SELECT s.*, cg.daily_fee FROM site s JOIN campground cg ON s.campground_id=cg.campground_id "
				+ " WHERE site_id NOT IN ( "
				+ " SELECT r.site_id FROM reservation r "
				+ " WHERE (r.from_date <=? AND r.to_date >=?)"
				+ ")   AND ("
				+ "SELECT cg.campground_id FROM campground cg WHERE cg.name LIKE ?) = s.campground_id ORDER BY s.site_id LIMIT 5";  
		Date dateStartDate = Date.valueOf(startDate);
		Date dateEndDate = Date.valueOf(endDate);
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sqlGetAllReservations, dateStartDate, dateEndDate, "%"+campground+"%");
		
		while(rows.next()) {
			Site rev = new Site();
			rev.setId(rows.getLong("site_id"));
			rev.setCampgroundId(rows.getLong("campground_id"));
			rev.setSiteNumber(rows.getLong("site_number"));
			rev.setMaxOccupancy(rows.getLong("max_occupancy"));
			rev.setAccessible(rows.getBoolean("accessible"));
			rev.setMaxRVLength(rows.getLong("max_rv_length"));
			rev.setUtilities(rows.getBoolean("utilities"));
			rev.setDailyFee(rows.getString("daily_fee"));
			site.add(rev);
		}
		return site;
	}

}
