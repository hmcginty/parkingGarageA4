package cs414.a4.hmcginty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ticket {

	private int ticketNum;
	private Date timeIn;
	private Date timeOut;
	private double costRate;
	
	public Ticket(int tNum, Date tStamp, double rate) {
		this.ticketNum = tNum;
		this.timeIn = tStamp;
		this.timeOut = null;
		this.costRate = rate;
	}

	// Not to be confused with toString() this is so that the customer has a ticket number
	public void printTicket() {
		System.out.println("\n Ticket number: " + this.ticketNum);
	}
	
	public int getTicketNum(){
		return this.ticketNum;
	}
	
	public void stampOutTime(Date tStamp){
		this.timeOut = tStamp;
	}
	
	// Calculation of cost based on minutes elapsed. 
	// Negative return is done as a precaution just in case some how timeOut is not initialized. 
	public double getTicketCost(){
		if(timeOut.equals(null)){
			return -1.0;
		}else{
			long diff = timeOut.getTime() - timeIn.getTime();
			long diffMinutes = diff / (60*1000) % 60; // calculation obtained from : http://www.mkyong.com/java/how-to-calculate-date-time-difference-in-java/
			return diffMinutes*this.costRate;
		}
	}
	
	// Override .equals for use in ArrayList contains.
	public boolean equals(Object o){
		if(this.ticketNum == ((Ticket) o).getTicketNum()){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		if(this.timeOut == null){
			return "Ticket number: " + ticketNum + " Time in: " + dateFormat.format(timeIn);
		}else{
			return "Ticket number: " + ticketNum + " Time in: " + dateFormat.format(timeIn) + " Time out: " + dateFormat.format(timeOut) + " TicketCost = " + this.getTicketCost();
		}
	}
}
