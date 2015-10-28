package cs414.a4.hmcginty;

import java.util.Scanner;

public class SystemInterface {

	public static void main(String[] args) {
		
		Scanner user_input = new Scanner(System.in);
		int user_value;
		boolean isDone = false;
		
		while(isDone == false){
			
			System.out.println("\n Welcome to the Parking Garage Sytem. Please select an operation by entering a number. ");
			System.out.println("");
			System.out.println("	1. Enter Garage");
			System.out.println("	2. Exit Garage");
			System.out.println("	3. Enter Admin mode");
			System.out.println("	4. Exit Application");
			System.out.println("");
			
			user_value = user_input.nextInt();
			
			switch (user_value) {
				case 1: 
					GarageView.enterGarage();
					break;
				case 2:
					GarageView.exitGarage();
					break;
				case 3:
					AdminView.enterAdminMode();
					break;
				case 4:
					System.out.println("\n Thank you for using the parking garage system. Goodbye. ");
					isDone = true;
					break;
				default:
					System.out.println("\n Please enter a number between 1 and 4 corresponding with the action you wish to accomplish.");
					break;
			}
		}
		user_input.close();

	}

}
