package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.JdbcSurveyDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;

public class JDBCSurveyDAOTest {

	private static SingleConnectionDataSource dataSource;
	private SurveyDao dao;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setUp() {
		dao = new JdbcSurveyDao(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Test
	public void testSave() {
		int id = 31;
		Survey survey = new Survey();
		survey.setSurveyId(31);
		survey.setActivityLevel("active");
		survey.setEmailAddress("aliciamfilippis@gmail.com");
		survey.setParkCode("GNP");
		survey.setState("Michigan");
		dao.save(survey);
		
		Survey surveyId = dao.getSurveyById(id);
		
		assertEquals(31, survey.getSurveyId());
	}
	
	@Test
	public void testGetSurveyById() {
		Survey survey = dao.getSurveyById(1);
	
		assertEquals("GNP", survey.getParkCode());
	}

}
