package Abstract;

abstract public class USB {
  public static String version = "1.0";

  public USB() {
    System.out.println("USB Default Constructor");
  }

  abstract void read();

  abstract void write();
}
