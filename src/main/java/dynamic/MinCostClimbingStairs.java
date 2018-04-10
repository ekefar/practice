package dynamic;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{0,0,1,1}));
    }

    public static int minCostClimbingStairs(int[] costs) {

        if(costs.length < 3) {
            return Math.min(costs[0], costs[1]);
        }

        int[] totalCosts = new int[costs.length];

        totalCosts[0] = costs[0];
        totalCosts[1] = costs[1];
        for (int i = 2; i < costs.length; i++) {
            totalCosts[i] = Math.min(totalCosts[i-1], totalCosts[i-2]) + costs[i];
        }

        return Math.min(totalCosts[totalCosts.length - 1], totalCosts[totalCosts.length - 2]);
    }
}
