package cs414.a4.hmcginty;

import static org.junit.Assert.*;

import org.junit.Test;

// Any methods not tested here were deemed trivial, entirely dependent on other classes functionality, or hard to test without a full system test.

public class GarageTest {

	@Test
	public void testGetAvailableCapacity() {
		Garage g1 = new Garage(2, 2.5);
		
		int test1 = g1.getAvailableCapacity();
		assertTrue(test1 == 2);
		
		g1.createTicket();
		int test2 = g1.getAvailableCapacity();
		assertTrue(test2 == 1);
		
		g1.createTicket();
		int test3 = g1.getAvailableCapacity();
		assertTrue(test3 == 0);
	}
	
	@Test
	public void testHasActiveTicket() {
		Garage g1 = new Garage(2, 2.5);
		g1.createTicket();
		
		boolean test1 = g1.hasActiveTicket(1);
		assertTrue(test1 == true);
		
		boolean test2 = g1.hasActiveTicket(4);
		assertTrue(test2 == false);
	}
	
	@Test
	public void testCreateTicket() {
		Garage g1 = new Garage(1, 2.5);
		boolean test1 = g1.createTicket();
		boolean test2 = g1.createTicket();
		
		assertTrue(test1 == true);
		assertTrue(test2 == false);
	}
	
	/*@Test
	public void testPunchOutTicket() {
		Garage g1 = new Garage(2, 2.5);
		g1.createTicket();
		g1.punchOutTicket(1);
		assertTrue(g1.hasActiveTicket(1) == false);
		assertTrue(g1.getAvailableCapacity() == 2);
	}*/
	
	@Test
	public void testGetCurrentStatus() {
		Garage g1 = new Garage(2, 2.5);
		String test1 = g1.getCurrentStatus();
		assertTrue(test1.equals("\n Current number of people in the garrage: 0\n Money earned: $0.0"));
		
		g1.createTicket();
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g1.punchOutTicket(1);
		g1.createTicket();
		String test2 = g1.getCurrentStatus();
		assertTrue(test2.equals("\n Current number of people in the garrage: 1\n Money earned: $2.5"));
		
	}

}
