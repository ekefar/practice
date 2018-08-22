package general;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/valid-perfect-square/description/
 */
public class PerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
    }

    public static boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long sqr = mid*mid;
            if(sqr < num) {
                left = mid + 1;
            } else if(sqr > num){
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
