package MultiplicationTable;

import java.util.Scanner;

public class Multiplication_table {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Input number: ");
    int userInput = input.nextInt();
    multiplicationTable(userInput);
  }

  static void multiplicationTable(int userInput) {
    for (int i = 1; i <= 10; i++) {
      System.out.print(userInput + " * " + i + " = ");
      System.out.println(userInput * i);
    }
  }
}
