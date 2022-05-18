public class BattleShipsGame {
  public static int rows = 10;
  public static int cols = 10;
  public static String[][] grid = new String[rows][cols];
  public static int playerShips;
  public static int computerShips;
  public static boolean oceanMapIsExist;
  public static int storedPlayerShips[][] = new int[rows][cols];
  public static int storedComputerShips[][] = new int[rows][cols];

  public static void main(String[] args) {
    System.out.println("**** Welcome to Battle Ships game ****");
    System.out.println("Right now, sea is empty");

    // Step 1 – Create the ocean map
    OceanMap.printOceanMap();

    // Step 2 – Deploy player’s ships
    PlayerShips.deployPlayerShips();

    // Step 3 - Deploy computer's ships
    ComputerShips.deployComputerShips();
  }
}