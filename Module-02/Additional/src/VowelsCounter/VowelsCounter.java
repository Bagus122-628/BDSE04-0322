package VowelsCounter;

import java.util.Scanner;

public class VowelsCounter {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner input = new Scanner(System.in);

    System.out.print("Enter text: ");
    String strVowels = input.nextLine().toLowerCase();
    calcVowels(strVowels);
  }

  static void calcVowels(String strVowels) {
    int vowelCounter = 0;
    for (int i = 0; i < strVowels.length(); i++) {
      char vowel = strVowels.charAt(i);
      if (vowel == 'a' || vowel == 'e' || vowel == 'i' || vowel == 'o' || vowel == 'u') {
        vowelCounter += 1;
      }
    }
    System.out.println("Number of vowel: " + vowelCounter);
  }
}
