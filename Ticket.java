package cs414.a4.hmcginty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Ticket {

	private int ticketNum;
	private Date inStamp;
	private Date outStamp;
	private double costRate;
	
	public Ticket(int tNum, Date tStamp, double rate) {
		this.ticketNum = tNum;
		this.inStamp = tStamp;
		this.outStamp = null;
		this.costRate = rate;
	}

	public void printTicket() {
		System.out.println("\n Ticket number: " + this.ticketNum);
	}
	
	public int getTicketNum(){
		return this.ticketNum;
	}
	
	public void stampOutTime(Date tStamp){
		this.outStamp = tStamp;
	}
	
	// Calculation of cost based on minutes elapsed. 
	// Negative return is done as a precaution just in case some how outStamp is not initialized. 
	public double getTicketCost(){
		if(outStamp.equals(null)){
			return -1.0;
		}else{
			long diff = outStamp.getTime() - inStamp.getTime();
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
		if(this.outStamp.equals(null)){
			return "Ticket number: " + ticketNum + " Time in: " + dateFormat.format(inStamp);
		}else{
			return "Ticket number: " + ticketNum + " Time in: " + dateFormat.format(inStamp) + " Time out: " + dateFormat.format(outStamp) + " TicketCost = " + this.getTicketCost();
		}
	}
}
