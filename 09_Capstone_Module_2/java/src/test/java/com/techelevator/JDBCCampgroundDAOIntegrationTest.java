package com.techelevator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc.JDBCCampgroundDAO;
import model.Campground;

public class JDBCCampgroundDAOIntegrationTest extends DAOIntegrationTest{

	private JDBCCampgroundDAO campDao;
	
	@Before
	public void setup() {
		campDao = new JDBCCampgroundDAO(getDataSource());
	}

	@Test
	public void getCampgroundsByParkIDReturnsList() {
		List<Campground> campList = campDao.getCampgroundByParkId(1L);

		assertEquals(3, campList.size());
	}

}
