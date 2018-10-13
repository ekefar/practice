package dynamic;

/**
 * @author : Alexander Serebriyan
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,22,99,1,2,3,4,5, 6}));
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] lengths = new int[nums.length];

        for(int i = 0; i< nums.length;i++) {

            lengths[i] = 1;
            for(int j = 0;j<=i; j++) {
                if(nums[i] > nums[j]) {
                    lengths[i] = Math.max(lengths[i], lengths[j] + 1);
                }
            }
        }

        return lengths[nums.length - 1];
    }

}
