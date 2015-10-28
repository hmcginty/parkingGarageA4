package cs414.a4.hmcginty;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Garage {

	private ArrayList<Ticket> ticketHistory;
	private ArrayList<Ticket> activeTickets;
	private int ticketCount; // Used as place marker for what the next ticket number should be. 
	private int capacity;
	private int load; // For clarification load is the number of vehicles currently in the garage.
	private double rate;
	private double moneyEarned;
	private EntryGate entry;
	private ExitGate exit;
	
	public Garage(int size, double parkingRate) {
		this.ticketHistory = new ArrayList<Ticket>();
		this.activeTickets = new ArrayList<Ticket>();
		this.ticketCount = 0;
		this.load = 0;
		this.capacity = size;
		this.rate = parkingRate;
		this.moneyEarned = 0.0;
		this.entry = new EntryGate();
		this.exit = new ExitGate();
	}
	
	
	
	
	/* Get, set, and check methods */
	
	public int getCapacity(){
		return this.capacity;
	}
	
	public int getAvailableCapacity(){
		return (this.capacity - this.load);
	}
	
	public double getParkingRate(){
		return this.rate;
	}

	public void setParkingRate(double newRate){
		this.rate = newRate;
	}
	
	public boolean hasActiveTicket(int ticketID) {
		for(Ticket t: this.activeTickets){
			if(t.getTicketNum() == ticketID){
				return true;
			}
		}
		return false;
	}
	
	
	
	
	/* Logic methods */
	
	// Should return true if load has not reached capacity.
	public boolean createTicket(){
		if(this.capacity - this.load == 0){
			System.out.println("\n Sorry the garage is full right now. Please come back later.");
			return false;
		}else{
			Calendar cal = Calendar.getInstance();
			Date tStamp = cal.getTime();
			Ticket t = new Ticket(this.ticketCount+1, tStamp);
			this.ticketCount = this.ticketCount++;
			t.printTicket();
			this.activeTickets.add(t);
			return true;
		}
		
	}
	
	// Precondition: Ticket was already verified to be in activeTickets.
	public void punchOutTicket(int ticketID){
		Ticket outTicket = null;
		
		for(Ticket t: this.activeTickets){
			if(t.getTicketNum() == ticketID){
				outTicket = t;
			}
		}
		Calendar cal = Calendar.getInstance();
		Date tOut = cal.getTime();
		outTicket.stampOutTime(tOut);
		double amountDue = outTicket.getTicketCost(this.rate);
		processPayment(amountDue);
		this.activeTickets.remove(outTicket);
		this.ticketHistory.add(outTicket);
	}
	
	public void processPayment(double amountDue){
		Scanner uIn = new Scanner(System.in);
		
		boolean validPayment = false;
		int uCard;
		
		while(validPayment == false){
			System.out.println(" The amount you owe is: " +  amountDue);
			System.out.println(" Please enter a valid credit card number.");
			uCard = uIn.nextInt();
			
			if(PaymentAuthentication.isValidPayment(uCard)){
				this.moneyEarned += amountDue;
				System.out.println("Thank for your payment.");
				System.out.println(amountDue + " will be charged to your card ");
				validPayment = true;
			}else{
				System.out.println(" I'm sorry that is not a valid credit card number.");
			}
		}
		uIn.close();
	}
	
	// Should open EntryGate and close EntryGate after small wait time.
	public void handleEntryGate(){
		System.out.println(" Opening gate ");
		this.entry.openGate();
		System.out.println("");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" Closing Gate");
		this.entry.closeGate();
	}
	
	// Should open ExitGate and close ExitGate after small wait time.
	public void handleExitGate(){
		System.out.println(" Opening gate ");
		this.exit.openGate();
		System.out.println("");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" Closing Gate");
		this.exit.closeGate();
	}
	
	

	/* Format for viewing information */
	
	// Returns formatted string of current load, and money collected. 
	public String getCurrentStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	// Returns minute by minute load and money collected. 
	public String getHistory() {
		// TODO Auto-generated method stub
		return null;
	}
}
