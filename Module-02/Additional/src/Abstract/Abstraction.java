package Abstract;

public class Abstraction {
  public static void main(String[] args) {
    Pendrive pendrive = new Pendrive();
    USBKeyboard usbKeyboard = new USBKeyboard();
    USB usb = new USBKeyboard();

    pendrive.write();
    pendrive.read();

    usbKeyboard.write();
    usbKeyboard.read();

    usb.write();
    usb.read();
  }
}
