package Abstract;

public class Pendrive extends USB {

  @Override
  void read() {
    System.out.println("Override from Pendrive");
    System.out.println(version);
  }

  @Override
  void write() {
    version = "2.0 Pendrive";
  }

}
