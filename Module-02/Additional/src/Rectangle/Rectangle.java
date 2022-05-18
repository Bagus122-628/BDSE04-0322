import java.util.Scanner;

public class Rectangle {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Input Widht: ");
    int width = input.nextInt();
    System.out.print("Input Length: ");
    int lenght = input.nextInt();

    calculateRectangle(width, lenght);
  }

  static void calculateRectangle(int widht, int lenght) {
    int area = lenght * widht;
    int perimeter = (2 * lenght) + (2 * widht);

    System.out.println("\nArea      : " + area);
    System.out.println("Perimeter : " + perimeter);
  }
}
