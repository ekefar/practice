package arrays;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinumumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(9, new int[]{3,3,3,2,4}));
    }

    public static int minSubArrayLen(int s, int[] nums) {

        if(nums.length == 0) {
            return 0;
        }

        int rightBound = 0;
        int leftBound = 0;

        int currentSum = nums[0];
        int minLen = Integer.MAX_VALUE;
        while (rightBound < nums.length-1 || leftBound < nums.length-1) {

            if(currentSum < s && rightBound < nums.length-1) {
                rightBound++;
                currentSum += nums[rightBound];
            } else if (leftBound < nums.length-1) {
                if(currentSum >= s) {
                    minLen = Math.min(minLen, rightBound - leftBound + 1);
                }
                currentSum -= nums[leftBound];
                leftBound++;
            }

        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}


