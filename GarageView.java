package cs414.a4.hmcginty;

import java.util.Scanner;

import cs414.a4.hmcginty.SystemInterface;

// Used as the interface to all operations that a customer will see with the garage.
// Note: Customer is not a class but the user of the application. No information needs to be stored about the customer other then the ticket number. 
public class GarageView {


	// Used to give interface to the enter garage functionality.
	public static void enterGarage(){
		
		Scanner uIn = new Scanner(System.in);
		
		boolean isDoneEntering = false;
		int uVal;
		
		while(isDoneEntering == false) {
			System.out.println("\n Welcome to the garage please select what you would like to do. \n");
			System.out.println("");
			System.out.println("	1. Print ticket and enter garage");
			System.out.println("	2. Exit and leave garage"); // This is for just in case a customer pulls up and decides they don't actually want to enter
			System.out.println("");
			
			uVal = uIn.nextInt();
			
			switch (uVal) {
				case 1:
					SystemInterface.g1.printTicket();
					isDoneEntering = true;
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
		
		uIn.close();
	}
	
	// Used to give interface to the exit garage functionality.
	public static void exitGarage(){
		
		Scanner uIn = new Scanner(System.in);
		
		boolean isDoneExiting = false;
		int uVal;
		
		while(isDoneExiting == false) {
			System.out.println("\n Thank you for visiting the garage plese enter your ticket number.");
			
			uVal = uIn.nextInt();
			
			if(SystemInterface.g1.hasActiveTicket(uVal)) {
				// print cost, validate payment and print receipt. 
			}else{
				System.out.println("\n Ticket is not valid, please make sure you entered the correct ticket number.");
			}
		}
		
		uIn.close();
	}
}
