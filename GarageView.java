package cs414.a4.hmcginty;

//import java.util.Scanner;

import cs414.a4.hmcginty.SystemInterface;

// Used as the interface to all operations that a customer will see with the garage.
// Note: Customer is not a class but the user of the application. No information needs to be stored about the customer other then the ticket number. 
public class GarageView {


	// Used to give interface to the enter garage functionality.
	public static void enterGarage(){
		
		boolean isDoneEntering = false;
		int uVal = 0;
		
		while(isDoneEntering == false) {
			
			System.out.println("\n Welcome to the garage please select what you would like to do. ");
			System.out.println("");
			System.out.println("	1. Print ticket and enter garage");
			System.out.println("	2. Exit and leave garage"); // This is for just in case a customer pulls up and decides they don't actually want to enter
			System.out.println("");
			

			String nextIntString = SystemInterface.user_input.nextLine();
			uVal = Integer.parseInt(nextIntString);
			
			switch (uVal) {
				case 1:
					boolean check = SystemInterface.g1.createTicket();
					if(check == true){
						SystemInterface.g1.handleEntryGate();
						isDoneEntering = true;
					}
					break;
				case 2:
					System.out.println("\n Thank you for stopping by");
					isDoneEntering = true;
					break;
				default:
					System.out.println("\n Please enter either 1 or 2");
					break;
			}
		}
	}
	
	// Used to give interface to the exit garage functionality.
	public static void exitGarage(){
		
		boolean isDoneExiting = false;
		int uVal;
		
		while(isDoneExiting == false) {
			System.out.println("\n Thank you for visiting the garage plese enter your ticket number.");
			
			String nextIntString = SystemInterface.user_input.nextLine();
			uVal = Integer.parseInt(nextIntString);
			
			if(SystemInterface.g1.hasActiveTicket(uVal)) {
				SystemInterface.g1.punchOutTicket(uVal);
				System.out.println("\n Have a nice Day!");
				SystemInterface.g1.handleExitGate();
				isDoneExiting = true;
			}else{
				System.out.println("\n Ticket is not valid, please make sure you entered the correct ticket number.");
			}
		}
		
	}
}
