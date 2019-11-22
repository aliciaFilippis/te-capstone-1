package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ChipsTest {

	Chips newChips = new Chips(null, null, 0);

	@Test
	public void testGetAndSetName() {
		newChips.setName("Chip");
		Assert.assertEquals("Chip", newChips.getName());
	}

	@Test
	public void testGetAndSetSlot() {
		newChips.setSlot("A1");
		Assert.assertEquals("A1", newChips.getSlot());
	}
	
	@Test
	public void testGetAndSetPrice() {
		newChips.setPrice(3.00);
		assertEquals(3.00, newChips.getPrice(), 0.000001);
	}
	
	@Test
	public void testGetAndSetQuantity() {
		newChips.setQuantity(5);
		Assert.assertEquals(5, newChips.getQuantity());
	}
	
	@Test
	public void quantityIsZero() {
		newChips.setQuantity(0);
		Assert.assertEquals(0, newChips.getQuantity());
	}

	@Test
	public void testGetAndSetMessage() {
		newChips.setMessage("Crunch Crunch, Yum!");
		Assert.assertEquals("Crunch Crunch, Yum!", newChips.getMessage());
	}

	@Test
	public void testDecrementQuantity() {
		newChips.decrementQuantity();
		Assert.assertEquals(4, newChips.getQuantity());
	}

}
