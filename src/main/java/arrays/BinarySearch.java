package arrays;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/binary-search/description/
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 11));
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] > target) {
                right = middle - 1;
            } else if(nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }

        }

        return -1;

    }
}
