package Interface;

public class Main {
  public static void main(String[] args) {
    Toyota toyota = new Toyota();
    Lamborghini lamborghini = new Lamborghini();

    toyota.displayCar();
    toyota.setPrice(32000);
    toyota.getPrice();

    lamborghini.displayCar();
    lamborghini.setPrice(1500000);
    lamborghini.getPrice();
  }
}
