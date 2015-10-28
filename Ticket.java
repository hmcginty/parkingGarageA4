package cs414.a4.hmcginty;

public class Ticket {

	private int ticketNum;
	
	public Ticket(int tNum) {
		this.ticketNum = tNum;
	}

	public void printTicket() {
		System.out.println("\n Ticket number: " + this.ticketNum);
	}
	
	public int getTicketNum(){
		return this.ticketNum;
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
