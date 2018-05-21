package arrays;

import javafx.util.Pair;

import java.util.HashMap;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class RangeSumQuery {

    int[] nums;
    public RangeSumQuery(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];

        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return nums[j];

        return nums[j] - nums[i - 1];
    }


    //caching solution
   /* private final HashMap<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

    public RangeSumQuery(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                cache.put(new Pair<>(i, j), sum);
            }
        }
    }

    public int sumRange(int i, int j) {
        return cache.get(new Pair<>(i, j));
    }
    */
}
