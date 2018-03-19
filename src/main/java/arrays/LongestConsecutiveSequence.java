package arrays;

import java.util.HashMap;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class LongestConsecutiveSequence {


    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,1,0, -1, -1,200,3,4,2}));
    }
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> numbers = new HashMap<>();

        for (int num : nums) {
            numbers.put(num, false);
        }

        int longestSequence = 0;
        for (Integer number : numbers.keySet()) {

            if (numbers.get(number)) {
                continue;
            }

            int length = 0;
            int current = number;
            while (numbers.get(current) != null) {
                numbers.put(current, true);
                length++;
                current++;
            }

            current = number - 1;
            while (numbers.get(current) != null) {
                numbers.put(current, true);
                length++;
                current--;
            }

            longestSequence = Math.max(longestSequence, length);

        }

        return longestSequence;
    }


}
