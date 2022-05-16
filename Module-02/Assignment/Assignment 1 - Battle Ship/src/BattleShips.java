public class BattleShips {
    public static int rows = 10;
    public static int cols = 10;
    public static String[][] grid = new String[rows][cols];

    public static void main(String[] args) {
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println("Right now, sea is empty\n");

        createOceanMap();
    }

    // Step 1 – Create the ocean map
    public static void createOceanMap() {
        System.out.print("  ");
        for (int i = 0; i < cols; i++) {
            System.out.print(i);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                if (j == 0) {
                    System.out.print(i + "|" + grid[i][j]);
                } else if (j == grid[i].length - 1) {
                    System.out.print(grid[i][j] + "|" + i);
                } else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }

        System.out.print("  ");
        for (int i = 0; i < cols; i++) {
            System.out.print(i);
        }
        System.out.println();
    }
}