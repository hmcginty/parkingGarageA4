package cs414.a4.hmcginty;

import java.util.ArrayList;

public class Garage {

	private ArrayList<Ticket> ticketHistory;
	private ArrayList<Ticket> activeTickets;
	private int ticketCount; // Used as place marker for what the next ticket number should be. 
	private int capacity;
	private int load; // For clarification load is the number of vehicles currently in the garage.
	private double rate;
	private EntryGate entry;
	private ExitGate exit;
	
	public Garage(int size, double parkingRate) {
		this.ticketHistory = new ArrayList<Ticket>();
		this.activeTickets = new ArrayList<Ticket>();
		this.ticketCount = 0;
		this.load = 0;
		this.capacity = size;
		this.rate = parkingRate;
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
		Ticket t = new Ticket(ticketID);
		if(this.activeTickets.contains(t)){
			return true;
		}else{
			return false;
		}
	}
	
	
	/* Logic methods */
	
	// Should return true if load has not reached capacity.
	public boolean createTicket(){
		if(this.capacity - this.load == 0){
			System.out.println("\n Sorry the garage is full right now. Please come back later.");
			return false;
		}else{
			Ticket t = new Ticket(this.ticketCount+1);
			this.ticketCount = this.ticketCount++;
			t.printTicket();
			this.activeTickets.add(t);
			return true;
		}
		
	}


	public String getCurrentStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getHistory() {
		// TODO Auto-generated method stub
		return null;
	}
}
