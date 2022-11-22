package lithan.training.javawebapp;

public class CreditCardProcessor implements PaymentProcessor{
	
	public boolean process() {
		System.out.println("Processing payment with Credit Card...");
		return true;
	}
}
