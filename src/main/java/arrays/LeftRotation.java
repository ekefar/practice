package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Alexander Serebriyan
 *
 * neat solution:
 *
 * for(int i = 0; i < lengthOfArray; i++){
 * int newLocation = (i + (lengthOfArray - shiftAmount)) % lengthOfArray;
 * a[newLocation] = in.nextInt();
}
 */
public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        System.out.println(Arrays.toString(a));

        final int[] toMove = Arrays.copyOfRange(a, 0, d);

        System.arraycopy(a, d, a, 0, n - d);

        System.arraycopy(toMove, 0, a, n - d, d);

        for (int anA : a) {
            System.out.print(anA);
        }
    }
}
