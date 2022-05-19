package SeparateNumber;

public class SeparateNumber {
  public static void main(String[] args) {
    separateNumber(122);
  }

  static void separateNumber(int number) {
    if (number > 0) {
      separateNumber(number / 10);
      System.out.println(number % 10);
    }
  }
}
