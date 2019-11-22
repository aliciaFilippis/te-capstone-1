package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc.JDBCReservationDAO;

public class JDBCReservationDAOIntegrationTest extends DAOIntegrationTest{

	private JDBCReservationDAO reservationDao;
	
	@Before
	public void setup() {
		reservationDao = new JDBCReservationDAO(getDataSource());
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
