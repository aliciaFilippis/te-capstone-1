package MakingChange;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class MakeChangeTest {
	
	MakeChange newMakeChange = new MakeChange();

	@Test
	public void testMakeChange() {
		newMakeChange.makeChange(2.0);
		assertEquals("Your change is 8 quarters", newMakeChange.makeChange(2.0));
	}
	
	@Test
	public void testMakeSecondChange() {
		newMakeChange.makeChange(2.20);
		assertEquals("Your change is 8 quarters and 2 dimes", newMakeChange.makeChange(2.20));
	}

	@Test
	public void testMakeThirdChange() {
		newMakeChange.makeChange(0.95);
		assertEquals("Your change is 3 quarters and 2 dimes", newMakeChange.makeChange(0.95));
	}
	
	@Test
	public void testMakeFourthChange() {
		newMakeChange.makeChange(0.05);
		assertEquals("Your change is 1 nickel", newMakeChange.makeChange(0.05));
	}
	
//	@Test
//	public void testMakeFifthChange() {
//		newMakeChange.makeChange(2.0);
//		assertEquals("Your change is 8 quarters", newMakeChange.makeChange(2.0));
//	}

}
