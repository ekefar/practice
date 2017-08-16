package general;

import java.util.Scanner;

/**
 * @author : Alexander Serebriyan
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(20));
        System.out.println(fibonacciNoRec(20));
    }

    public static int fibonacci(int n) {
        // Complete the function.
        if (n < 2) {
            return n;
        }

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int fibonacciNoRec(int n) {

        // Complete the function.
        if (n < 2) {
            return n;
        }

        int prevPrev = 0;
        int prev = 1;

        int next = 0;
        for (int i = 2; i <= n; i++) {
            next = prev + prevPrev;
            prevPrev = prev;
            prev = next;
        }

        return next;
    }


}
