package cs414.a4.hmcginty;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntryGateTest {

	@Test
	public void testIsOpenFalse() {
		EntryGate e1 = new EntryGate();
		boolean test1 = e1.isOpen();
		assertFalse(test1);
	}
	
	@Test
	public void testOpenGateCloseGate() {
		EntryGate e1 = new EntryGate();
		assertEquals(e1.isOpen(), false);
		e1.openGate();
		assertEquals(e1.isOpen(), true);
		e1.closeGate();
		assertEquals(e1.isOpen(), false);
	}
	
	@Test
	public void testIsOpenTrue() {
		EntryGate e1 = new EntryGate();
		e1.openGate();
		boolean test1 = e1.isOpen();
		assertTrue(test1);
	}

}
