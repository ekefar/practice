package arrays;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSorted {

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5};
        int res = removeDuplicates(ints);
        System.out.println(res);
    }


    public static int removeDuplicates(int[] nums) {

        if(nums.length == 0) {
            return 0;
        }

        int prev = nums[0];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num != prev) {
                nums[k] = num;
                prev = num;
                k++;
            }
        }

        return k;
    }

}
