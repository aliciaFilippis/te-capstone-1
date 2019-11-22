package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc.JDBCSiteDAO;

public class JDBCSiteDAOIntegrationTest extends DAOIntegrationTest{

	private JDBCSiteDAO siteDao;
	
	@Before 
	public void setup() {
		siteDao = new JDBCSiteDAO(getDataSource()); 
	}

}
