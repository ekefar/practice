package arrays;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/find-pivot-index/description/
 */
public class FindPivotIndex {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,0,1}));
    }

    public static int pivotIndex(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;


        int leftSum = nums[leftIndex];
        int rightSum = nums[rightIndex];
        while (rightIndex - leftIndex > 2) {

            if (Math.abs(leftSum) >= Math.abs(rightSum)) {
                rightIndex--;
                rightSum += nums[rightIndex];
            } else {
                leftIndex++;
                leftSum += nums[leftIndex];
            }
        }

        if (leftSum == rightSum) {
            return leftIndex + 1;
        } else {
            return -1;
        }

    }

//    works for this case: {-1,-1,-1,0,1,1}, when answer is 0 index element

    public int pivotIndex2(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
