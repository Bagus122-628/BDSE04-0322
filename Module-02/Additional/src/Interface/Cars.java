package Interface;

interface Cars {
  void displayCar();
}

interface Cars2 {
  int setPrice(int price);

  void getPrice();
}

class Toyota implements Cars, Cars2 {
  private int price;

  @Override
  public void displayCar() {
    System.out.println("Toyota");
  }

  @Override
  public int setPrice(int price) {
    return this.price = price;

  }

  @Override
  public void getPrice() {
    System.out.println("Price: $" + price);
  }

}

class Lamborghini implements Cars, Cars2 {
  private int price;

  @Override
  public void displayCar() {
    System.out.println("Lamborghini");
  }

  @Override
  public int setPrice(int price) {
    return this.price = price;

  }

  @Override
  public void getPrice() {
    System.out.println("Price: $" + price);
  }

}