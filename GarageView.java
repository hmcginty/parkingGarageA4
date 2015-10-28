package cs414.a4.hmcginty;


// Used as the interface to all operations that a customer will see with the garage.
// Note that customer is not a class but the user of the application.
public class GarageView {


	// Used to give interface to the enter garage functionality.
	public static void enterGarage(){
		System.out.println("\n Welcome to the garage please select what you would like to do. \n");
	}
	
	// Used to give interface to the exit garage functionality.
	public static void exitGarage(){
		System.out.println("\n Thank you for visiting the garage plese enter your ticket number. \n");
	}
}
