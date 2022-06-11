import java.io.File;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    MCQ mcq = new MCQ();

    Scanner input = new Scanner(System.in);
    System.out.print("Enter your name : ");
    String inputUserName = input.nextLine();

    System.out.println("\nChoose your Multiple Choice Question Set. The Options are : ");
    // Generate Files Name
    File folder = new File("src/MCQ");
    File[] listOfFiles = folder.listFiles();
    generateFilesName(folder, listOfFiles);

    // Take user input to MCQ set question
    System.out.print("Type your choice(without spacing) : ");
    String inputUserChoice = input.nextLine();
    boolean mcqSetsNotExist = true;

    while (mcqSetsNotExist) {
      for (int i = 0; i < listOfFiles.length; i++) {
        String fileName = listOfFiles[i].getName();
        int extension = fileName.lastIndexOf(".");
        if (extension > 0) {
          fileName = fileName.substring(0, extension).toLowerCase();
          if (fileName.equals(inputUserChoice.toLowerCase())) {
            mcq.Questions(inputUserChoice, inputUserName);
            mcqSetsNotExist = false;
          }
        }
      }
      if (mcqSetsNotExist) {
        System.out.println("Theres no such MCQ or Task");
        System.out.print("Type your choice(without spacing) : ");
        inputUserChoice = input.nextLine();
      }
    }

  }

  static void generateFilesName(File folder, File[] listOfFiles) {
    for (int i = 0; i < listOfFiles.length; i++) {
      String fileName = listOfFiles[i].getName();
      int extension = fileName.lastIndexOf(".");
      if (extension > 0) {
        fileName = fileName.substring(0, extension);
        if (listOfFiles[i].isFile()) {
          System.out.println(fileName);
        }
      }
    }
  }

}
