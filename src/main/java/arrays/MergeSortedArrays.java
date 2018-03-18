package arrays;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        merge(nums1, 5, nums2, 3);
        System.out.println(nums1);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {

            int num1 = i < m ? nums1[i] : Integer.MAX_VALUE;
            int num2 = j < n ? nums2[j] : Integer.MAX_VALUE;

            if (num1 > num2) {
                result[k] = num2;
                j++;
            } else {
                result[k] = num1;
                i++;
            }

            k++;

        }


        System.arraycopy(result, 0, nums1, 0, nums1.length);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        while (j >= 0) nums1[k--] = nums2[j--];
    }
}
