package arrays;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumSorted {

    public static void main(String[] args) {
        int[] x = twoSum(new int[]{2, 3, 4, 6, 7, 9, 10}, 7);
        System.out.println(x);
    }

    public static int[] twoSum(int[] numbers, int target) {

        int leftBound = 0;
        int rightBound = numbers.length - 1;

        int sum = numbers[leftBound] + numbers[rightBound];
        while (sum != target) {

            if (sum > target) {
                rightBound--;
            } else {
                leftBound++;
            }

            sum = numbers[leftBound] + numbers[rightBound];
        }

        return new int[]{leftBound + 1, rightBound + 1};
    }
}
