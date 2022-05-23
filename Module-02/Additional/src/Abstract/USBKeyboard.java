package Abstract;

public class USBKeyboard extends USB {

  @Override
  void read() {
    System.out.println("Override from USB Keyboard");
    System.out.println(version);
  }

  @Override
  void write() {
    version = "3.0 USB Keyboard";
  }

}
