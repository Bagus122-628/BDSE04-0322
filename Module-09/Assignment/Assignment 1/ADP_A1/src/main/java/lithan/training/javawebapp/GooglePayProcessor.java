package lithan.training.javawebapp;

public class GooglePayProcessor implements PaymentProcessor{

	public boolean process() {
		System.out.println("Processing payment with Google Pay...");
		return true;
	}

}
