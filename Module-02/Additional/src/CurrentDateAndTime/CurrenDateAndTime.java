package CurrentDateAndTime;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrenDateAndTime {
  public static void main(String[] args) {
    // Date Time Formatter
    DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/mm/dd");
    DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime current = LocalDateTime.now();

    System.out.println("Current Date: " + date.format(current));
    System.out.println("Current Time: " + time.format(current));

    // Simple Date Format
    SimpleDateFormat date2 = new SimpleDateFormat("yyyy/mm/dd");
    SimpleDateFormat time2 = new SimpleDateFormat("HH:mm:ss");
    Date current2 = new Date();
    System.out.println("\nCurrent Date: " + date2.format(current2));
    System.out.println("Current Time: " + time2.format(current2));
  }
}
