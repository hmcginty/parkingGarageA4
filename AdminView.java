package cs414.a4.hmcginty;


// Used as the view an administrator will have when they wish to query the system for necessary information. 
// Note: Administrator is a class because the administrator will have to have login credentials and in real life would have a lot
// 		of information associated with them such as title, salary, employee id, etc but that is not a primary concern with this program.  
public class AdminView {

	public static void enterAdminMode(){
		System.out.println("\n Welcome Admin, please select the information you wish to obtain. \n");
	}
}
