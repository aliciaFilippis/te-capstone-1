package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DrinksTest {

	Drinks newDrink = new Drinks(null, null, 0);

	@Test
	public void testGetAndSetName() {
		newDrink.setName("Drink");
		Assert.assertEquals("Drink", newDrink.getName());
	}

	@Test
	public void testGetAndSetSlot() {
		newDrink.setSlot("C1");
		Assert.assertEquals("C1", newDrink.getSlot());
	}
	
	@Test
	public void testGetAndSetPrice() {
		newDrink.setPrice(5.00);
		assertEquals(5.00, newDrink.getPrice(), 0.000001);
	}
	
	@Test
	public void testGetAndSetQuantity() {
		newDrink.setQuantity(5);
		Assert.assertEquals(5, newDrink.getQuantity());
	}
	
	@Test
	public void quantityIsZero() {
		newDrink.setQuantity(0);
		Assert.assertEquals(0, newDrink.getQuantity());
	}

	@Test
	public void testGetAndSetMessage() {
		newDrink.setMessage("Glug Glug, Yum!");
		Assert.assertEquals("Glug Glug, Yum!", newDrink.getMessage());
	}

	@Test
	public void testDecrementQuantity() {
		newDrink.decrementQuantity();
		Assert.assertEquals(4, newDrink.getQuantity());
	}

}
