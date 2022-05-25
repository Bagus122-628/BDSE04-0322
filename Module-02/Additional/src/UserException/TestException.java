package UserException;

public class TestException {

  public static void test(int number) throws UserException {
    if (number >= 18) {
      throw new UserException("Throw user defined exception");
    } else {
      System.out.println("Test");
    }
  }

}
