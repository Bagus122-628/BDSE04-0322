package Recursion;

public class RecursionFactorial {

  public static void main(String[] args) {
    System.out.println(factorialRecursive(20));
  }

  static long factorialRecursive(long value) {
    if (value == 1) {
      return 1;
    } else {
      return value * factorialRecursive(value - 1);
    }
  }
}
