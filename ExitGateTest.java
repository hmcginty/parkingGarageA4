package cs414.a4.hmcginty;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExitGateTest {

	@Test
	public void testIsOpenFalse() {
		ExitGate e1 = new ExitGate();
		boolean test1 = e1.isOpen();
		assertFalse(test1);
	}
	
	@Test
	public void testOpenGateCloseGate() {
		ExitGate e1 = new ExitGate();
		assertEquals(e1.isOpen(), false);
		e1.openGate();
		assertEquals(e1.isOpen(), true);
		e1.closeGate();
		assertEquals(e1.isOpen(), false);
	}
	
	@Test
	public void testIsOpenTrue() {
		ExitGate e1 = new ExitGate();
		e1.openGate();
		boolean test1 = e1.isOpen();
		assertTrue(test1);
	}

}
