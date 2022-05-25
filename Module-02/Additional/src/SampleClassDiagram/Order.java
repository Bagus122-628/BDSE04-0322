package SampleClassDiagram;

import java.util.Date;

public class Order {
  public Date date = new Date();
  public String number;

  public Order(Date date, String number) {
    this.date = date;
    this.number = number;
  }

  public void confirm() {
  }

  public void close() {
  }

}
