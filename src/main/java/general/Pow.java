package general;

/**
 * @author : Alexander Serebriyan
 */
public class Pow {


    public static void main(String[] args) {
        System.out.println(myPow(34.00515,
                -3));
        System.out.println(Math.pow(34.00515,
                -3));
    }

    public static double myPow(double x, int n) {

        if(n==0 || x==1) {
            return 1;
        } else if(n==-2147483648) {
            return x == -1? 1:0;
        }

        double res = x;

        long nDecreased = 1;
        long absN = Math.abs(Long.valueOf(n));
        while (absN > 0) {
            res *= res;
            absN-= nDecreased;
            nDecreased *=2;
        }

        for (int i = 0; i < Math.abs(absN) + 1; i++) {
            res /= x;
        }

        if (n < 0) {
            return 1.0 / res;
        }


        return res;
    }

    public static double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }

        double ans = 1;
        double currentProduct = x;
        for (long i = N; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                ans = ans * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
        }
        return ans;
    }


}
