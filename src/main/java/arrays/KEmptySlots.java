package arrays;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @author : Alexander Serebriyan
 *         <p>
 *         There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.
 *         <p>
 *         Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.
 *         <p>
 *         For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.
 *         <p>
 *         Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.
 *         <p>
 *         If there isn't such day, output -1.
 *         <p>
 *         Example 1:
 *         Input:
 *         flowers: [1,3,2]
 *         k: 1
 *         Output: 2
 *         Explanation: In the second day, the first and the third flower have become blooming.
 *         Example 2:
 *         Input:
 *         flowers: [1,2,3]
 *         k: 1
 *         Output: -1
 *         Note:
 *         The given array will be in the range [1, 20000].
 */
public class KEmptySlots {

    public static void main(String[] args) {
//        final int result = kEmptySlots(new int[]{1, 3, 2}, 1);
        final int result = kEmptySlots(new int[]{1, 2, 3}, 1);
        System.out.println(result);

    }

    public static int kEmptySlots(int[] flowers, int k) {

        final int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i] - 1] = i + 1;
        }

        int left = 0;
        int right = k + 1;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < days.length && right < days.length; i++) {
            int day = days[i];
            if (day > days[left] && day > days[right]) {
                continue;
            }

            if (i == right) {
                res = Math.min(res, Math.max(days[left], days[right]));
            }

            left = i;
            right = i + k + 1;

        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
