package cs414.a4.hmcginty;

import java.util.ArrayList;

public class Garage {

	private ArrayList<Ticket> ticketHistory;
	private ArrayList<Ticket> activeTickets;
	private int capacity;
	private int load; // For clarification load is the number of vehicles currently in the garage.
	private double rate;
	private EntryGate entry;
	private ExitGate exit;
	
	public Garage(int size, double parkingRate) {
		this.ticketHistory = new ArrayList<Ticket>();
		this.activeTickets = new ArrayList<Ticket>();
		this.load = 0;
		this.capacity = size;
		this.rate = parkingRate;
		this.entry = new EntryGate();
		this.exit = new ExitGate();
	}
	
	public int getCapacity(){
		return this.capacity;
	}
	
	public int getAvailableCapacity(){
		return (this.capacity - this.load);
	}
	
	public double getParkingRate(){
		return this.rate;
	}

	public void printTicket() {
		// TODO Auto-generated method stub
		
	}

	public boolean hasActiveTicket(int ticketID) {
		// TODO Auto-generated method stub
		return false;
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
