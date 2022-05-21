public class Main {
  public static void main(String[] args) {
    System.out.println("**** Welcome to Battle Ships game ****");
    System.out.println("Right now, sea is empty");

    // Step 1 – Create the ocean map
    BattleShipsGame.printOceanMap();

    // Step 2 – Deploy player’s ships
    BattleShipsGame.deployPlayerShips();

    // Step 3 - Deploy computer's ships
    BattleShipsGame.deployComputerShips();

    // Step 4 – Battle
    do {
      BattleShipsGame.battleShips();
    } while (BattleShipsGame.playerShips > 0 && BattleShipsGame.computerShips > 0);

    // Step 5 - Game Over
    BattleShipsGame.gameOver();
  }
}
