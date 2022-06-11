import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class MCQ {

  public void Questions(String CSV) throws Exception {
    String line = "";
    FileReader fr = new FileReader("src/MCQ/" + CSV + ".csv");
    BufferedReader br = new BufferedReader(fr);
    while ((line = br.readLine()) != null) {
      String[] mcqStr = line.split(","); // use comma as separator
      List<String> listMcqStr = Arrays.asList(mcqStr);

      // Print Questions
      System.out.println(listMcqStr.get(0));
      // Print Answer
      for (int i = 2; i < 6; i++) {
        System.out.println(listMcqStr.get(i));
      }

      // System.out.println(mcqStr[0]);
      // System.out.println(mcqStr[1]);
    }
  }

}
