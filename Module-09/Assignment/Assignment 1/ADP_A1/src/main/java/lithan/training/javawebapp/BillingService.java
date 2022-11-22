package lithan.training.javawebapp;

public class BillingService {
	private PaymentProcessor paymentProcessor;
	  
	public boolean completePayment() {
		return paymentProcessor.process();
	}
	
	// 1.	Enhance the BillingService class so it gets instantiated and the dependencies shall get injected
	public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
		this.paymentProcessor = paymentProcessor;
	}

}
