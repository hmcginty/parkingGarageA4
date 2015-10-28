package cs414.a4.hmcginty;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TicketTest {

	@Test
	public void testGetTicketCost() {
		Date d1 = null;
		Date d2 = null;
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		String dateStart = "10/28/2015 16:00:36";
		String dateStop = "10/28/2015 16:10:36";
		
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ticket t1 = new Ticket(1, d1, 1.5);
		t1.stampOutTime(d2);
		
		double cost = t1.getTicketCost();
		assertTrue(cost == 15.00);
	}
	
	@Test
	public void testEqualsMethod() {
		Date d1 = null;
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		String dateStart = "10/28/2015 16:00:36";
		
		try {
			d1 = format.parse(dateStart);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ticket t1 = new Ticket(1, d1, 1.5);
		Ticket t2 = new Ticket(1, d1, 1.5);
		Ticket t3 = new Ticket(2, d1, 1.5);
		assertTrue(t1.equals(t2));
		assertFalse(t1.equals(t3));
	}
	
	@Test
	public void testToString() {
		Date d1 = null;
		Date d2 = null;
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		String dateStart = "10/28/2015 16:00:36";
		String dateStop = "10/28/2015 16:10:36";
		
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ticket t1 = new Ticket(1, d1, 1.5);
		
		String test1 = t1.toString();
		assertTrue(test1.equals("Ticket number: 1 Time in: 10/28/2015 16:00:36"));
		
		t1.stampOutTime(d2);
		String test2 = t1.toString();
		assertTrue(test2.equals("Ticket number: 1 Time in: 10/28/2015 16:00:36 Time out: 10/28/2015 16:10:36 TicketCost = 15.0"));
	}

}
