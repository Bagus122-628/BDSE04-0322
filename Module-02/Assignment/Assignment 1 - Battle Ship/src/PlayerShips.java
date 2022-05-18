import java.util.Scanner;

public class PlayerShips extends BattleShipsGame {
  static void deployPlayerShips() {
    playerShips = 5;

    @SuppressWarnings("resource")
    Scanner userInput = new Scanner(System.in);

    System.out.println("Deploy your ships:");

    for (int i = 1; i <= playerShips;) {
      System.out.print("Enter X coordinate for your " + i + ". ship: ");
      int x = userInput.nextInt();
      System.out.print("Enter Y coordinate for your " + i + ". ship: ");
      int y = userInput.nextInt();

      if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == " ")) {
        grid[x][y] = "@";
        storedPlayerShips[x][y] = 1;
        i++;
      } else if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == "@")) {
        System.out.println("you can NOT place two or more ships on the same location");
      } else if ((x < 0 || x >= rows) || (y < 0 || y >= cols)) {
        System.out.println("you can't place ships outside the 10 by 10 grid");
      }
    }
    OceanMap.printOceanMap();
  }
}
