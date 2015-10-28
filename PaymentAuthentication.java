package cs414.a4.hmcginty;

public class PaymentAuthentication {

	private static  int validCard1 = 1234;
	private static  int validCard2 = 4321;
	
	public static boolean isValidPayment(int cardNum){
		if(cardNum == validCard1 || cardNum == validCard2){
			return true;
		}else{
			return false;
		}
	}
}
