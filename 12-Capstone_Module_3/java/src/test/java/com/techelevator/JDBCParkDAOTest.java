package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.JbdcParkDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;

public class JDBCParkDAOTest {
	
	private static SingleConnectionDataSource dataSource;
	private ParkDao dao;

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
		dao = new JbdcParkDao(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Test
	public void testGetAllParks() {
		List<Park> parkList = dao.getAllParks();
		
		assertEquals(10, parkList.size());
		
		Park name = parkList.get(0);
		assertEquals("Cuyahoga Valley National Park", name.getParkname());
	}
	
	@Test
	public void testGetParkById() {
		Park park = dao.getParkById("GNP");
	
		assertEquals("GNP", park.getParkcode());
	}

}
