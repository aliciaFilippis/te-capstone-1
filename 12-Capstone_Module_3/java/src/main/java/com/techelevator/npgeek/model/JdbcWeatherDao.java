package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDao implements WeatherDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeatherByParkCode(String parkcode) {
		List<Weather> weatherList = new ArrayList<>();
		String weatherListSql = "select * from park" +
				" inner join weather" +
				" on weather.parkcode = park.parkcode" +
				" where park.parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(weatherListSql, parkcode);
		while (results.next()) {
			weatherList.add(mapRowToWeather(results));
		}
		return weatherList;
	}
	
	private Weather mapRowToWeather(SqlRowSet row) {
		Weather weather = new Weather();
		weather.setParkCode(row.getString("parkcode"));
		weather.setForeCastValue(row.getInt("fivedayforecastvalue"));
		weather.setLow(row.getInt("low"));
		weather.setHigh(row.getInt("high"));
		weather.setForeCast(row.getString("forecast"));
		return weather;
	}

}
