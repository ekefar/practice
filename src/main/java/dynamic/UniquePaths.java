package dynamic;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        grid[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i +1 < m) {
                    grid[i+1][j] += grid[i][j];
                }

                if(j+1 < n) {
                    grid[i][j+1] += grid[i][j];
                }
            }
        }

        return grid[m-1][n-1];
    }
}
