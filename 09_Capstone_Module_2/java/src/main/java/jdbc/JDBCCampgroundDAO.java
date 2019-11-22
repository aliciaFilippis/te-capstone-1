package jdbc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import model.Campground;
import model.CampgroundDAO;

public class JDBCCampgroundDAO implements CampgroundDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Campground> getAllCampgrounds() {
		
		List<Campground> campgroundList = new ArrayList<Campground>();

		String sqlString = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee FROM campground";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlString);
		while (results.next()) {
			Campground campground = new Campground();
			Long campId = results.getLong("campground_id");
			campground.setId(campId);
			Long parkId = results.getLong("park_id");
			campground.setParkId(parkId);
			String tempName = results.getString("name");
			campground.setName(tempName);
			String openDate = results.getString("open_from_mm");
			campground.setOpenFrom(openDate);
			String closeDate = results.getString("open_from_mm");
			campground.setOpenTo(closeDate);
			String dailyFee = results.getString("daily_fee");
			campground.setDailyFee(dailyFee);
			campgroundList.add(campground);
		}
		return campgroundList;
	}
	
	public List<Campground> getCampgroundByParkId(Long parkId) {
		List<Campground> campList = new ArrayList<Campground>();
		Campground campground = new Campground();

		String sqlString = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee FROM campground";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlString);
		while (results.next()) {
			Long campId = results.getLong("campground_id");
			campground.setId(campId);
			Long parkId1 = results.getLong("park_id");
			campground.setParkId(parkId);
			String tempName = results.getString("name");
			campground.setName(tempName);
			String openDate = results.getString("open_from_mm");
			campground.setOpenFrom(openDate);
			String closeDate = results.getString("open_from_mm");
			campground.setOpenTo(closeDate);
			String dailyFee = results.getString("daily_fee");
			campground.setDailyFee(dailyFee);
			campList.add(campground);
		}
		return campList;
		
	}
	
	@Override
	public List<Campground> getCampgrounds(String campSearch) {
		List<Campground> campgrounds = new ArrayList<>();
		
		String sqlGetAllCampgrounds = "SELECT * FROM campground c JOIN park p ON p.park_id=c.park_id"
				+ "  WHERE upper(p.name) LIKE ? OR lower(p.name) LIKE ? OR p.name LIKE ?"
				+ " ORDER BY c.name";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCampgrounds, "%"+campSearch+"%", "%"+campSearch+"%", "%"+campSearch+"%");
		
		while (results.next()) {
			Campground campground = new Campground();
			Long campId = results.getLong("campground_id");
			campground.setId(campId);
			Long parkId = results.getLong("park_id");
			campground.setParkId(parkId);
			String tempName = results.getString("name");
			campground.setName(tempName);
			String openDate = results.getString("open_from_mm");
			campground.setOpenFrom(openDate);
			String closeDate = results.getString("open_from_mm");
			campground.setOpenTo(closeDate);
			String dailyFee = results.getString("daily_fee");
			campground.setDailyFee(dailyFee);
			campgrounds.add(campground);
		}
		return campgrounds;
	}


	
	@Override
	public List<Campground> searchCampgroundByName(String nameSearch) {
		List<Campground> campgrounds = new ArrayList<>();
		
		String sqlSearchCampgroundByName = "SELECT * FROM campground WHERE name LIKE ? OR upper(name) LIKE ? OR lower(name) LIKE ?"; 
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchCampgroundByName, "%"+nameSearch+"%", "%"+nameSearch+"%", "%"+nameSearch+"%");
		while (results.next()) {
			Campground campground = new Campground();
			Long campId = results.getLong("campground_id");
			campground.setId(campId);
			Long parkId = results.getLong("park_id");
			campground.setParkId(parkId);
			String tempName = results.getString("name");
			campground.setName(tempName);
			String openDate = results.getString("open_from_mm");
			campground.setOpenFrom(openDate);
			String closeDate = results.getString("open_from_mm");
			campground.setOpenTo(closeDate);
			String dailyFee = results.getString("daily_fee");
			campground.setDailyFee(dailyFee);
			campgrounds.add(campground);
		}
		return campgrounds;
	}
	
	
	
}
