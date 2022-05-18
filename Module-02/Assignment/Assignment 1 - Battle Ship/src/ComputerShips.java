public class ComputerShips extends BattleShipsGame {
  static void deployComputerShips() {
    computerShips = 5;

    System.out.println("Computer is deploying ships");

    for (int i = 0; i < computerShips;) {
      int x = (int) (Math.random() * 10);
      int y = (int) (Math.random() * 10);

      if ((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == " ")) {
        grid[x][y] = " ";
        storedComputerShips[x][y] = 2;
        System.out.println((i + 1) + ". ship DEPLOYED");
        i++;
      }
    }
    OceanMap.printOceanMap();
  }
}
