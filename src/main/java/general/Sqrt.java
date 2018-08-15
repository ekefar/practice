package general;

/**
 * @author : Alexander Serebriyan
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(36));
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1;
        int right = x;
        int middle = 0;
        while (left <= right) {
            middle = left + (right - left) / 2;


            if (x / middle < middle) {
                right = middle - 1;
            } else {
                if (middle + 1 > x / (middle + 1)) {
                    return (int) middle;
                }
                left = middle + 1;
            }
        }

        return (int) middle;
    }
}
