package arrays;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaxSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            currentMax = Math.max(num, num + currentMax);
            max = Math.max(max, currentMax);
        }

        return max;
    }
}
