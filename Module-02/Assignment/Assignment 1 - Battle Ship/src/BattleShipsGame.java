import java.util.Scanner;

public class BattleShipsGame {
  static int rows = 10;
  static int cols = 10;
  static String[][] grid = new String[rows][cols];
  static int playerShips;
  static boolean oceanMapIsExist;

  public static void main(String[] args) {
    System.out.println("**** Welcome to Battle Ships game ****");
    System.out.println("Right now, sea is empty");

    printOceanMap();
    deployPlayerShips();
  }

  // Step 1 – Create the ocean map
  static void printOceanMap() {
    System.out.print("\n  ");
    for (int i = 0; i < cols; i++) {
      System.out.print(i);
    }
    System.out.println();

    if (oceanMapIsExist == true) {
      // Print Ocean Map if Ocean Map is exist
      for (int x = 0; x < grid.length; x++) {
        System.out.print(x + "|");
        for (int y = 0; y < grid[x].length; y++) {
          System.out.print(grid[x][y]);
        }
        System.out.println("|" + x);
      }
    } else {
      // Create Ocean Map if Ocean Map isn't exist
      for (int x = 0; x < grid.length; x++) {
        for (int y = 0; y < grid[x].length; y++) {
          grid[x][y] = " ";
          if (y == 0) {
            System.out.print(x + "|" + grid[x][y]);
          } else if (y == grid[x].length - 1) {
            System.out.print(grid[x][y] + "|" + x);
          } else {
            System.out.print(grid[x][y]);
          }
        }
        System.out.println();
      }
      oceanMapIsExist = true;
    }

    System.out.print("  ");
    for (int i = 0; i < cols; i++) {
      System.out.print(i);
    }
    System.out.println("\n");
  }

  // Step 2 – Deploy player’s ships
  static void deployPlayerShips() {
    playerShips = 5;
    Scanner userInput = new Scanner(System.in);

    System.out.println("Deploy your ships:");

    for (int i = 1; i <= playerShips;) {
      System.out.print("Enter X coordinate for your " + i + ". ship: ");
      int x = userInput.nextInt();
      System.out.print("Enter Y coordinate for your " + i + ". ship: ");
      int y = userInput.nextInt();

      if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == " ")) {
        grid[x][y] = "@";
        i++;
      } else if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == "@")) {
        System.out.println("you can NOT place two or more ships on the same location");
      } else if ((x < 0 || x >= rows) || (y < 0 || y >= cols)) {
        System.out.println("you can't place ships outside the 10 by 10 grid");
      }
    }
    printOceanMap();
  }
}