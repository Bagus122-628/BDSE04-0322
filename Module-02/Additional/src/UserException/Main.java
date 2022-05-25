package UserException;

public class Main {
  public static void main(String[] args) {
    try {
      TestException.test(20);
    } catch (UserException e) {
      e.printStackTrace();
    }
  }
}
