package general;

import java.util.Scanner;

/**
 * @author : Alexander Serebriyan
 */
public class Fibonacci {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i));
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacciNoRec(i));
        }
    }


    static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    static int fibonacciNoRec(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev = 1;
        int prevPrev = 1;
        int current = 0;

        for (int i = 0; i < n; i++) {
            current = prev + prevPrev;

            prevPrev = prev;
            prev = current;
        }

        return current;
    }


}
