package general;

import java.util.HashMap;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    public static void main(String[] args) {
        final int[] sol = twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 11);
        System.out.println(sol);
    }

    public static int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> diffs = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(diffs.containsKey(num)) {
                return new int[]{diffs.get(num), i};
            }

            diffs.put(target - num, i);
        }

        throw new IllegalStateException();
    }
}
