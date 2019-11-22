package com.techelevator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc.JDBCParkDAO;
import model.Campground;
import model.Park;

public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest {

	private JDBCParkDAO parkDao;

	@Before
	public void setup() {
		parkDao = new JDBCParkDAO(getDataSource());
	}

	@Test
	public void getAllParksReturnsList() {
		List<Park> parkList = parkDao.getAllParks();

		assertEquals(3, parkList.size());
	}
	
	@Test
	public void getParkByNameReturnsCorrectPark() {
		List<Park> testParkList = parkDao.getAllParks();
		Park testParkFromList = testParkList.get(0);
		
		String parkName = testParkFromList.getName();
		String parkLocation = testParkFromList.getLocation();
		
		List<Park> testPark = parkDao.getParkByName(parkName);
		
		assertEquals(parkName, testPark.getName());
		assertEquals(parkLocation, testPark.getLocation());
	}
}
