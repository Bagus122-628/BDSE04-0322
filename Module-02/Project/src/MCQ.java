import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MCQ {

  public void Questions(String CSV) throws FileNotFoundException {
    Scanner sc = new Scanner(new File("src/MCQ/" + CSV + ".csv"));
    sc.useDelimiter(",");
    while (sc.hasNext()) {
      System.out.print(sc.next());
    }
    sc.close();
  }

}
