package dynamic;

/**
 * @author : Alexander Serebriyan
 */
public class GivingChange {

    public static void main(String[] args) {
//        System.out.println(minNumCoins(24, new int[] {1,10, 25}));
        System.out.println(minNumCoins(11, new int[] {1,3,4,5}));
        int[] arr = new int[10];
        System.out.println(arr);
    }

    static int minNumCoins(int n, int[] coins) {

        int[] coinsNum = new int[n+1];


//        1 1 2 2 3 4

//        1 1 1 1 2 2


        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {

                if (i>=coin) {
                    min= Math.min(min, coinsNum[i - coin]+1);
                }
            }

            if(min!=Integer.MAX_VALUE) {
                coinsNum[i]+=min;
            }
        }

        return coinsNum[n];
    }
}
