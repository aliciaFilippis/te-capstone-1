package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {

	Gum newGum = new Gum(null, null, 0);

	@Test
	public void testGetAndSetName() {
		newGum.setName("Gum");
		Assert.assertEquals("Gum", newGum.getName());
	}

	@Test
	public void testGetAndSetSlot() {
		newGum.setSlot("D1");
		Assert.assertEquals("D1", newGum.getSlot());
	}
	
	@Test
	public void testGetAndSetPrice() {
		newGum.setPrice(5.00);
		assertEquals(5.00, newGum.getPrice(), 0.000001);
	}
	
	@Test
	public void testGetAndSetQuantity() {
		newGum.setQuantity(5);
		Assert.assertEquals(5, newGum.getQuantity());
	}
	
	@Test
	public void quantityIsZero() {
		newGum.setQuantity(0);
		Assert.assertEquals(0, newGum.getQuantity());
	}

	@Test
	public void testGetAndSetMessage() {
		newGum.setMessage("Chew Chew, Yum!");
		Assert.assertEquals("Chew Chew, Yum!", newGum.getMessage());
	}

	@Test
	public void testDecrementQuantity() {
		newGum.decrementQuantity();
		Assert.assertEquals(4, newGum.getQuantity());
	}

}
