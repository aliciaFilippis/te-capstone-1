package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {
	
	Candy newCandy = new Candy(null, null, 0);

	@Test
	public void testGetAndSetName() {
		newCandy.setName("Candy");
		Assert.assertEquals("Candy", newCandy.getName());
	}

	@Test
	public void testGetAndSetSlot() {
		newCandy.setSlot("B1");
		Assert.assertEquals("B1", newCandy.getSlot());
	}
	
	@Test
	public void testGetAndSetPrice() {
		newCandy.setPrice(10.00);
		assertEquals(10.00, newCandy.getPrice(), 0.000001);
	}
	
	@Test
	public void testGetAndSetQuantity() {
		newCandy.setQuantity(5);
		Assert.assertEquals(5, newCandy.getQuantity());
	}
	
	@Test
	public void quantityIsZero() {
		newCandy.setQuantity(0);
		Assert.assertEquals(0, newCandy.getQuantity());
	}

	@Test
	public void testGetAndSetMessage() {
		newCandy.setMessage("Munch Munch, Yum!");
		Assert.assertEquals("Munch Munch, Yum!", newCandy.getMessage());
	}

	@Test
	public void testDecrementQuantity() {
		newCandy.decrementQuantity();
		Assert.assertEquals(4, newCandy.getQuantity());
	}

}
