package arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/find-k-closest-elements/description/
 */
public class FindNClosestElements {

    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 7, 8, 8, 10, 17};
        int[] arr = {0,1,2,3,4,4,4,5,5,5,6,7,9,9,10,10,11,11,12,13,14,14,15,17,19,19,22,24,24,25,25,27,27,29,30,32,32,33,33,35,36,38,39,41,42,43,44,44,46,47,48,49,52,53,53,54,54,57,57,58,59,59,59,60,60,60,61,61,62,64,66,68,68,70,72,72,74,74,74,75,76,76,77,77,80,80,82,83,85,86,87,87,92,93,94,96,96,97,98,99};
//        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        int k = 25;
        int x = 90;
        System.out.println(getClosestToTarget(arr, x));
        System.out.println(findClosestElements(arr, k, x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int mid = getClosestToTarget(arr, x);

        int left = mid;
        int right = mid;


        while (right - left < k - 1) {

            int leftNumber = left > 0 ? arr[left - 1] : arr[left];
            int rightNumber = right < arr.length - 1 ? arr[right + 1] : arr[right];

            int leftDiff = Math.abs(x - leftNumber);
            int rightDiff = Math.abs(x - rightNumber);

            if (leftDiff <= rightDiff && left > 0 || right == arr.length - 1) {
                left--;
            } else if (right < arr.length - 1) {
                right++;
            }

        }


        LinkedList<Integer> result = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;

    }

    private static int getClosestToTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (right >= left) {
            mid = left + (right - left) / 2;

            int current = arr[mid];
            if (current > target && mid > 0
                    && Math.abs(target - arr[mid - 1]) <= Math.abs(target - current)) {
                right = mid - 1;
            } else if (current < target && mid < arr.length - 1
                    && Math.abs(target - arr[mid + 1]) <= Math.abs(target - current)) {
                left = mid + 1;
            } else {
                break;
            }
        }
        return mid;
    }
}
