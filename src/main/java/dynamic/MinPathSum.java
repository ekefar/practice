package dynamic;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int[][] sums = new int[grid.length][grid[0].length];
        sums[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (i < grid.length - 1) {
                    if (sums[i + 1][j] == 0) {
                        sums[i + 1][j] = sums[i][j] + grid[i + 1][j];
                    } else {
                        sums[i + 1][j] = Math.min(sums[i][j] + grid[i + 1][j], sums[i + 1][j]);
                    }
                }

                if (j < grid[i].length - 1) {
                    if (sums[i][j + 1] == 0) {
                        sums[i][j + 1] = sums[i][j] + grid[i][j + 1];
                    } else {
                        sums[i][j + 1] = Math.min(sums[i][j] + grid[i][j + 1], sums[i][j + 1]);
                    }
                }
            }

        }

        return sums[grid.length - 1][grid[0].length - 1];
    }
}
