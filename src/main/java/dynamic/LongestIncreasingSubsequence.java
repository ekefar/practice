package dynamic;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[]{10,22,99,1,2,3,4,5, 6}));
//        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

    public static int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int[] lengths = new int[nums.length];

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {

            lengths[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    lengths[i] = Math.max(lengths[i], lengths[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, lengths[i]);
        }

        return maxLen;
    }

}
