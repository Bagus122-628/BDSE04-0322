import java.util.Scanner;

public class BattleShipsGame {
  public static int rows = 10;
  public static int cols = 10;
  public static int playerShips;
  public static int computerShips;
  public static boolean oceanMapIsExist;
  public static String[][] grid = new String[rows][cols];
  public static int[][] storedShips = new int[rows][cols];

  public static void main(String[] args) {
    System.out.println("**** Welcome to Battle Ships game ****");
    System.out.println("Right now, sea is empty");

    // Step 1 – Create the ocean map
    printOceanMap();

    // Step 2 – Deploy player’s ships
    deployPlayerShips();

    // Step 3 - Deploy computer's ships
    deployComputerShips();

    // Step 4 – Battle
    do {
      battleShips();
    } while (playerShips != 0 && computerShips != 0);

    // Step 5 - Game Over
    gameOver();
  }

  // Step 1 – Create the ocean map
  public static void printOceanMap() {
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
  public static void deployPlayerShips() {
    playerShips = 5;

    @SuppressWarnings("resource")
    Scanner userInput = new Scanner(System.in);

    System.out.println("Deploy your ships:");

    for (int i = 1; i <= playerShips;) {
      System.out.print("Enter X coordinate for your " + i + ". ship: ");
      int y = userInput.nextInt();
      System.out.print("Enter Y coordinate for your " + i + ". ship: ");
      int x = userInput.nextInt();

      if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == " ")) {
        grid[x][y] = "@";
        storedShips[x][y] = 1;
        i++;
      } else if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == "@")) {
        System.out.println("you can NOT place two or more ships on the same location");
      } else if ((x < 0 || x >= rows) || (y < 0 || y >= cols)) {
        System.out.println("you can't place ships outside the 10 by 10 grid");
      }
    }
    printOceanMap();
  }

  // Step 3 - Deploy computer's ships
  public static void deployComputerShips() {
    computerShips = 5;

    System.out.println("Computer is deploying ships");

    for (int i = 0; i < computerShips;) {
      int x = (int) (Math.random() * 10);
      int y = (int) (Math.random() * 10);

      if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == " ")) {
        storedShips[x][y] = 2;
        System.out.println((i + 1) + ". ship DEPLOYED");
        i++;
      }
    }
    printOceanMap();
  }

  // Step 4 – Battle
  public static void battleShips() {
    playerTurn();
    computerTurn();
    printOceanMap();

    System.out.println();
    System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
    System.out.println();
  }

  // Player Turn
  public static void playerTurn() {
    System.out.println("\nYOUR TURN");
    boolean invalidGuess = false;
    boolean validGuess = false;
    int x = 0;
    int y = 0;
    do {
      @SuppressWarnings("resource")
      Scanner input = new Scanner(System.in);
      System.out.print("Enter X coordinate: ");
      y = input.nextInt();
      System.out.print("Enter Y coordinate: ");
      x = input.nextInt();

      validGuess = (x >= 0 && x < rows) && (y >= 0 && y < cols);
      invalidGuess = (x < 0 || x >= rows) || (y < 0 || y >= cols);

      if (validGuess) {
        if (storedShips[x][y] == 2) {
          System.out.println("Boom! You sunk the ship!");
          storedShips[x][y] = 3;
          grid[x][y] = "!";
          --computerShips;
        } else if (storedShips[x][y] == 1) {
          System.out.println("Oh no, you sunk your own ship :(");
          storedShips[x][y] = 3;
          grid[x][y] = "x";
          --playerShips;
        } else if (storedShips[x][y] != 2 || storedShips[x][y] != 1) {
          System.out.println("Sorry, you missed");
          grid[x][y] = "-";
        }

      } else if (invalidGuess) {
        System.out.println("You can't place ships outside the " + rows + " by " + cols + " grid");
      }
    } while (invalidGuess);
  }

  // Computer Turn
  public static void computerTurn() {
    System.out.println("\nCOMPUTER'S TURN");
    boolean invalidGuess = false;
    boolean validGuess = false;
    int x = 0;
    int y = 0;

    do {
      x = (int) (Math.random() * 10);
      y = (int) (Math.random() * 10);

      validGuess = (x >= 0 && x < rows) && (y >= 0 && y < cols) && storedShips[x][y] != 3;
      invalidGuess = storedShips[x][y] == 3;

      if (validGuess) {
        if (storedShips[x][y] == 1) {
          System.out.println("The Computer sunk one of your ships!");
          grid[x][y] = "x";
          --playerShips;
        } else if (storedShips[x][y] == 2) {
          System.out.println("The Computer sunk one of its own ships");
          grid[x][y] = "!";
          --computerShips;
        } else if (storedShips[x][y] != 1 || storedShips[x][y] != 2) {
          System.out.println("Computer missed");
          storedShips[x][y] = 3;
        }
      }
    } while (invalidGuess);
  }

  // Step 5 - Game Over
  public static void gameOver() {
    printOceanMap();
    System.out.println("Your ships: " + playerShips + " | " + "Computer ships: " + computerShips);

    if (playerShips > 0 && computerShips <= 0) {
      System.out.println("Hooray You win the battle :)");
    } else {
      System.out.println("Computer win the battle, You Lose :(");
    }
  }
}