package dynamic;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] steps = {1, 2};   // possible step size

        int[] stairs = new int[n + 1];

        for (int stepSize : steps) {
            stairs[stepSize] = 1;    // initialize initial ways for each step size
        }

        for (int i = 0; i < stairs.length; i++) {
            int res = stairs[i];

            // sum ways for all possible step sizes
            // stairs[i] = stairs[i-stepSize1] + stairs[i-stepSize2] + ... + stairs[i-stepSizeN];
            for (int stepSize : steps) {
                if (i >= stepSize) {
                    res += stairs[i - stepSize];
                }
            }

            stairs[i] = res;
        }

        return stairs[n];
    }
}
