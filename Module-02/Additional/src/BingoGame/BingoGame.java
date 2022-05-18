package BingoGame;

public class BingoGame {
  public static void main(String[] args) {
    printBingo();
  }

  static void printBingo() {
    for (int i = 1; i <= 50; i++) {
      if (i % 5 == 0) {
        System.out.println("Bingo ");
      } else {
        System.out.print(i + " ");
      }
    }
  }
}
