package ShoppingCart;

import java.util.Scanner;

public class ShoppingCart {
  public static void main(String[] args) {
    int price;
    int totalBill = 0;
    int itemCount = 0;
    char confirm;

    @SuppressWarnings("resource")
    Scanner input = new Scanner(System.in);

    do {
      System.out.print("Add item to cart (y/n)");
      confirm = input.next().toLowerCase().charAt(0);

      if (confirm != 'y') {
        System.out.println("\nThank You!!");
        break;
      }

      System.out.print("Enter the price: ");
      price = input.nextInt();
      totalBill += price;
      itemCount++;
    } while (true);

    System.out.println("Item count: " + itemCount);
    System.out.println("Your total bill: " + totalBill);
  }
}
