package dynamic;

/**
 * @author : Alexander Serebriyan
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,22,9,33,21,50,41,60, 80}));
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
