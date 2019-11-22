package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//tested
	@Override
	public void save(Survey post) {
		int id = getNextId();
		String sqlInsertReview = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertReview, id, post.getParkCode(), post.getEmailAddress(), post.getState(),
				post.getActivityLevel());
		post.setSurveyId(id);
	}
	
	//tested
	@Override
	public Survey getSurveyById(int id) {
		Survey survey = null;
		String sql = "SELECT * FROM survey_result where surveyid = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			survey = mapRowToSurvey(results);
		}
		return survey;

	}
	
	private int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		int id = 0;
		if (results.next()) {
			id = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next survey post id from sequence");
		}
		return id;
	}
	
	private Survey mapRowToSurvey(SqlRowSet results) {
		Survey survey = new Survey();
		survey.setSurveyId(results.getInt("surveyid"));
		survey.setState(results.getString("state"));
		survey.setParkCode(results.getString("parkcode"));
		survey.setEmailAddress(results.getString("emailaddress"));
		survey.setActivityLevel(results.getString("activitylevel"));
		return survey;
	}

}
