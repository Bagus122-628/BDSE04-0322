import java.util.Scanner;

public class Circle {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter Radius of Circle:");
    double userInput = input.nextDouble();

    calculateCircle(userInput);
  }

  static void calculateCircle(double userInput) {
    double radius = userInput;
    double area;
    double perimeter;
    area = Math.PI * radius * radius;
    perimeter = 2 * Math.PI * radius;

    System.out.println("Area of Circle : " + area);
    System.out.println("Perimeter of Circle : " + perimeter);
  }
}
