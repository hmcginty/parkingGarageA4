package cs414.a4.hmcginty;

//import java.util.Calendar;
import java.util.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;

public class Ticket {

	private int ticketNum;
	private Date inStamp;
	private Date outStamp;
	
	public Ticket(int tNum, Date tStamp) {
		this.ticketNum = tNum;
		this.inStamp = tStamp;
		this.outStamp = null;
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
	public double getTicketCost(double rate){
		long diffMinutes = outStamp.getTime() - inStamp.getTime();
		return diffMinutes*rate;
	}
	
	// Override .equals for use in ArrayList contains.
	public boolean equals(Object o){
		if(this.ticketNum == ((Ticket) o).getTicketNum()){
			return true;
		}else{
			return false;
		}
	}
	
}
