package arrays;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '0', '0', '1'},
                {'1', '1', '1', '0'},
                {'0', '0', '1', '1'},
                {'1', '0', '1', '1'},
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int islandsCount = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                char cell = row[j];

                if (cell == '1') {
                    markAdjacent(grid, i, j);

                    islandsCount++;
                }

            }
        }

        return islandsCount;
    }

    public static void markAdjacent(char[][] grid, int i, int j) {
        if (i<0 || j<0 ||
                i >= grid.length ||
                j >= grid[i].length ||
                grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'v';
        markAdjacent(grid, i + 1, j);
        markAdjacent(grid, i, j + 1);
        markAdjacent(grid, i, j - 1);
        markAdjacent(grid, i - 1, j);
    }
}
