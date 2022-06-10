import java.io.BufferedReader;
import java.io.FileReader;

public class MCQ {

  public void Questions(String CSV) throws Exception {
    String line = "";
    FileReader fr = new FileReader("src/MCQ/" + CSV + ".csv");
    BufferedReader br = new BufferedReader(fr);
    while ((line = br.readLine()) != null) {
      String[] mcqStr = line.split(","); // use comma as separator
      System.out.println(mcqStr[1]);
    }
  }

}
