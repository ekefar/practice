package dynamic;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/maximum-product-subarray/description/
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {3,-1,4}));
    }

    public static int maxProduct(int[] nums) {

        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if(nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }

            max = Math.max(nums[i]*max, nums[i]);
            min = Math.min(nums[i]*min, nums[i]);

            res = Math.max(res, max);
        }

        return res;
    }
}


