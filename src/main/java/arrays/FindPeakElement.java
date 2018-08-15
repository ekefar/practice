package arrays;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/find-peak-element/description/
 */
public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,1,1,1,1,6,1}));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length -1 ;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(mid > left && nums[mid-1] >= nums[mid]) {
                right = mid - 1;
            } else if(mid < right && nums[mid+1] >= nums[mid]) {
                left = mid +1;
            } else {
                return mid;
            }
        }

        return 0;
    }
}
