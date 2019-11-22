package jdbc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import model.Campground;
import model.Park;
import model.ParkDAO;

public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Park> getAllParks() {

		List<Park> parkList = new ArrayList<Park>();

		String sqlString = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlString);
		while (results.next()) {
			Park park = new Park();
			Long parkId = results.getLong("park_id");
			park.setId(parkId);
			String tempName = results.getString("name");
			park.setName(tempName);
			String location = results.getString("location");
			park.setLocation(location);
			Long area = results.getLong("area");
			park.setArea(area);
			Long visitors = results.getLong("visitors");
			park.setVisitors(visitors);
			String description = results.getString("description");
			park.setDescription(description);
			parkList.add(park);
		}
		return parkList;
	}

	public Park getParkByName(String nameSearch) {

		List<Park> park = new ArrayList<Park>();
		Park park1 = new Park();
		String sqlString = "SELECT * FROM park WHERE name LIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlString, "%" + nameSearch + "%");
		while (results.next()) {
		
			Long parkId = results.getLong("park_id");
			park1.setId(parkId);
			String tempName = results.getString("name");
			park1.setName(tempName);
			String location = results.getString("location");
			LocalDate estabDate = results.getDate("establish_date").toLocalDate();
			park1.setEstablishDate(estabDate);
			park1.setLocation(location);
			Long area = results.getLong("area");
			park1.setArea(area);
			Long visitors = results.getLong("visitors");
			park1.setVisitors(visitors);
			String description = results.getString("description");
			park1.setDescription(description);
		}
		return park1;
	}

	public Park createPark(String name, String location, LocalDate establishedDate, Long area, Long visitors,
			String description) {
		String sqlGetNextInt = "SELECT nextval('park_park_id_seq')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetNextInt);
		results = jdbcTemplate.queryForRowSet(sqlGetNextInt);
		results.next();
		Long id = results.getLong(1);

		String sqlCreatePark = "INSERT INTO park(park_id, name, location, established_date, area, visitors, description)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";

		Park newPark = new Park();
		jdbcTemplate.update(sqlCreatePark, id, name, location, establishedDate, area, visitors, description);

		newPark.setId(id);
		newPark.setName("name");
		newPark.setEstablishDate(establishedDate);
		newPark.setArea(area);
		newPark.setVisitors(visitors);
		newPark.setDescription("description");

		return newPark;
	}

}
