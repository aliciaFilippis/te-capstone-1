package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CustomerMoneyTest {
	
	CustomerMoney newCustomerMoney = new CustomerMoney();

	@Test
	public void testGetCurrentBal() {
		newCustomerMoney.addToCurrent(5);
		assertEquals(5, newCustomerMoney.getCurrentBal(), 0.000001);
	}
	
	@Test
	public void testTwoCurrentBal() {
		newCustomerMoney.addToCurrent(5);
		newCustomerMoney.addToCurrent(5);
		assertEquals(10, newCustomerMoney.getCurrentBal(), 0.000001);
	}

	@Test
	public void testAddToCurrent() {
		newCustomerMoney.addToCurrent(5);
		newCustomerMoney.addToCurrent(5);
		newCustomerMoney.addToCurrent(5);
		assertEquals(15, newCustomerMoney.getCurrentBal(), 0.000001);
	}

}
