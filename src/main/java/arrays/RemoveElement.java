package arrays;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 4, 5, 4, 6, 4};
        System.out.println(removeElement(nums, 4));

        System.out.println(nums);
    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
