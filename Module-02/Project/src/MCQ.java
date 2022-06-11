import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MCQ {

  public void Questions(String CSV, String userName) throws Exception {
    int score = 0;
    int wrongCounter = 0;
    Scanner sc = new Scanner(System.in);
    String line = "";
    FileReader fr = new FileReader("src/MCQ/" + CSV + ".csv");
    BufferedReader br = new BufferedReader(fr);
    while ((line = br.readLine()) != null) {
      String[] mcqStr = line.split(","); // use comma as separator
      List<String> listMcqStr = Arrays.asList(mcqStr);

      // Print Questions
      System.out.println(listMcqStr.get(0));

      // Print Multiple Choice
      for (int i = 1; i < 5; i++) {
        System.out.println(listMcqStr.get(i));
      }

      // User Answer
      boolean validAnswer = false;
      System.out.print("Your Answer : ");
      String userAnswer = sc.nextLine().toUpperCase();
      String correctAnswer = listMcqStr.get(5);

      // If user type an invalid answer
      while (!validAnswer) {
        if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D")) {
          validAnswer = true;
        } else {
          System.out.println("Please select the available answer");
          System.out.print("Your Answer : ");
          userAnswer = sc.nextLine().toUpperCase();
        }
      }

      System.out.println("\nYour Answer is : " + userAnswer);

      // Check if user answer is correct or wrong
      if (userAnswer.equals(correctAnswer.substring(0, 1))) {
        System.out.println("Your answer is correct!");
        score++;
      } else {
        System.out.println("Wrong Answer. The Correct Answer is " + correctAnswer);
        wrongCounter++;
      }
      System.out.println();
    }

    // Print Score
    System.out.println(userName + ", you answered " + score
        + " Questions Right, " + wrongCounter + " Questions Wrong for a Total of 10 Questions. You scored "
        + (score * 10)
        + "%");
  }

}
