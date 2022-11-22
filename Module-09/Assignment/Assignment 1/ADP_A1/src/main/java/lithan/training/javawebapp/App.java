package lithan.training.javawebapp;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
        
        Scanner input = new Scanner(System.in);
        System.out.println("Choose which payment method you would like to use");
        System.out.println("(1): Google Pay");
        System.out.println("(2): Credit Card");
        int mode = input.nextInt();
        
        String paymentMethod = "";
        boolean paymentSucceed = false;
        BillingService service = null;
        
        if(mode == 1) {
        	service = (BillingService) context.getBean("gpay-service");
        	paymentMethod = "Google Pay";
        	paymentSucceed = service.completePayment();
        } else if (mode == 2) {
        	service = (BillingService) context.getBean("credit-card-service");
        	paymentMethod = "Credit Card";
        	paymentSucceed = service.completePayment();
		} else {
			System.out.println("Choose between 1 or 2");
		}
        
        if(paymentSucceed) {
        	System.out.println("Succesfully payed with " + paymentMethod);
        }
        
    }
}
