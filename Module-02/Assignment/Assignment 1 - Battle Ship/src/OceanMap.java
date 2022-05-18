public class OceanMap extends BattleShipsGame {
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
}
