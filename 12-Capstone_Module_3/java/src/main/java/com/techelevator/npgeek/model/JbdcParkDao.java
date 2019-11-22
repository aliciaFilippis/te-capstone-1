package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
@Component
public class JbdcParkDao implements ParkDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JbdcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getSurveyResults() {
		List<Park> surveys = new ArrayList<>();
		String sql = "select count(survey_result.parkcode), park.parkname, park.parkcode from survey_result join park on park.parkcode = survey_result.parkcode group by park.parkname, park.parkcode order by count desc";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Park survey = new Park();
			survey.setParkcode(results.getString("parkcode"));
			survey.setParkname(results.getString("parkname"));
			survey.setCount(results.getInt("count"));
			surveys.add(survey);
		}
		return surveys;
	}

	//tested
	@Override
	public List<Park> getAllParks() {
		List<Park> parkList = new ArrayList<>();
		String parkListsql = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(parkListsql);
		while (results.next()) {
			parkList.add(mapRowToPark(results));
		}
		return parkList;
	}

	//tested
	@Override
	public Park getParkById(String parkcode) {
		Park park = null;
		String parkCodeSql = "SELECT * FROM park where parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(parkCodeSql, parkcode);
		if (results.next()) {
			park = mapRowToPark(results);
		}
		return park;

	}

	private Park mapRowToPark(SqlRowSet row) {
		Park park = new Park();
		park.setParkcode(row.getString("parkcode"));
		park.setParkname(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getInt("acreage"));
		park.setElevationInFeet(row.getInt("elevationinfeet"));
		park.setMilesOfTrail(row.getBigDecimal("milesOfTrail"));
		park.setNumberOfCampsites(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearfounded"));
		park.setAnnualVisitorCount(row.getInt("annualvisitorcount"));
		park.setInspoQuote(row.getString("inspirationalquote"));
		park.setInspoQuoteSource(row.getString("inspirationalquotesource"));
		park.setParkDescription(row.getString("parkdescription"));
		park.setEntryFee(row.getInt("entryfee"));
		park.setNumberOfAnimalSpecies(row.getInt("numberofanimalspecies"));
		return park;
	}
}
