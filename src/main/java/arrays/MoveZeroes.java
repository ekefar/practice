package arrays;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeroes {

    public static void main(String[] args) {
        final int[] ints = {1, 2, 0, 6, 0, 8, 0, 6, 4, 0, 8, 0, 7, 2, 0};

        moveZeroes(ints);
        System.out.println(ints);
    }

    public static void moveZeroes(int[] nums) {


        int moved = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num != 0) {
                nums[moved] = num;
                moved++;
            }
        }

        for (int i = moved; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
