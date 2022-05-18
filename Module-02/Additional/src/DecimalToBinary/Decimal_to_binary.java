import java.util.Scanner;

public class Decimal_to_binary {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Input number: ");
    int userInput = input.nextInt();
    toBinary(userInput);
  }

  static void toBinary(int userInput) {
    int index = 1;
    int binary = 0;
    int remainder;
    int decimal = userInput;

    while (decimal != 0) {
      remainder = decimal % 2;
      System.out.println("\nremainder : " + remainder);

      binary += index * remainder;
      System.out.println("binary    : " + binary);

      decimal = decimal / 2;
      System.out.println("decimal   : " + decimal);

      index = index * 10;
      System.out.println("index     : " + index);
      System.out.println("binary    : " + binary);
    }
    System.out.println("\nBinary of " + userInput + " = " + binary);
  }
}
