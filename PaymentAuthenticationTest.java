package cs414.a4.hmcginty;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaymentAuthenticationTest {

	@Test
	public void testIsValidPaymentTrue() {
		boolean test1 = PaymentAuthentication.isValidPayment(1234);
		assertTrue(test1);
		boolean test2 = PaymentAuthentication.isValidPayment(4321);
		assertTrue(test2);
	}
	
	@Test
	public void testIsValidPaymentFalse() {
		boolean test1 = PaymentAuthentication.isValidPayment(5678);
		assertFalse(test1);
		boolean test2 = PaymentAuthentication.isValidPayment(12);
		assertFalse(test2);
		boolean test3 = PaymentAuthentication.isValidPayment(12345);
		assertFalse(test3);
	}

}
