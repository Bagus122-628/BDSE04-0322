package CompareTwoNumbers;

import java.util.Scanner;

public class Compare_2_numbers {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner input = new Scanner(System.in);

    System.out.print("Input Number 1: ");
    int numb1 = input.nextInt();
    System.out.print("Input Number 2: ");
    int numb2 = input.nextInt();

    compareTwoNumbers(numb1, numb2);
  }

  static void compareTwoNumbers(int numb1, int numb2) {
    if (numb1 == numb2) {
      System.out.println("Numbers are equal");
    } else if (numb1 > numb2) {
      System.out.println(numb1 + " is greater than " + numb2);
    } else {
      System.out.println(numb2 + " is greater than " + numb1);
    }
  }
}
