package cs414.a4.hmcginty;

import java.util.Scanner;

import cs414.a4.hmcginty.SystemInterface;

// Used as the view an administrator will have when they wish to query the system for necessary information. 
// Note: Administrator is also not a class because they are merely a user of the system.
// Note: May include an administrator class in order to have a credential verification factor but not a focus for demo.
public class AdminView {

	public static void enterAdminMode(){
		
		Scanner uIn = new Scanner(System.in);
		
		boolean isDoneAdminMode = false;
		int uVal;
		
		while(isDoneAdminMode == false) {
			System.out.println("\n Welcome Admin, please select the information you wish to obtain. \n");
			System.out.println("");
			System.out.println("	1. View current garage status");
			System.out.println("	2. View garage history");
			System.out.println("	3. Logout");
			System.out.println("");
			
			uVal = uIn.nextInt();
			
			switch (uVal){
				case 1:
					getGarageStatus();
					break;
				case 2:
					getGarageHistory();
					break;
				case 3:
					System.out.println("\n Have a nice day!");
					isDoneAdminMode = true;
					break;
				default:
					
					break;
			}
		}
	}
	
	// Displays current number of active tickets in the system and current money gathered. 
	public static void getGarageStatus(){
		
	}
	
	// Displays time lapse of number of people in the garage and money earned. 
	// Going to show per minute since there is no database back end and this makes for faster testing of concept.  
	public static void getGarageHistory(){
		
	}
}
