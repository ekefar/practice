package arrays;

/**
 * @author : Alexander Serebriyan
 */
public class ConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,2,3,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int currentCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                res = Math.max(res, currentCount);
                currentCount = 0;
            }
        }

        res = Math.max(res, currentCount);
        return res;
    }
}
