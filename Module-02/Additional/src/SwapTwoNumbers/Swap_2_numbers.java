package SwapTwoNumbers;

import java.util.Scanner;

public class Swap_2_numbers {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Input number 1: ");
    int numb1 = input.nextInt();
    System.out.print("Input number 2: ");
    int numb2 = input.nextInt();
    swapNumber(numb1, numb2);
  }

  static void swapNumber(int numb1, int numb2) {
    System.out.println("Number 1 : " + numb1);
    System.out.println("Number 2 : " + numb2);

    numb1 = numb1 + numb2;
    numb2 = numb1 - numb2;
    numb1 = numb1 - numb2;

    System.out.println("Swapped");
    System.out.println("Number 1 : " + numb1);
    System.out.println("Number 2 : " + numb2);
  }
}
