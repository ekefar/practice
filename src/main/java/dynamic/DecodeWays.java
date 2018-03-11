package dynamic;

import java.util.Iterator;

/**
 * @author : Alexander Serebriyan
 */
public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("123"));


    }

    public static int numDecodings(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        final char[] chars = s.toCharArray();
        char prev = chars[0];
        for(int i = 2; i <= n; i++) {

            int currentChar = chars[i-1] - '0';
            int possibleTwoDigit = Integer.valueOf("" + (prev -'0') + currentChar);
            if(currentChar >= 1 && currentChar <= 9) {
                dp[i] += dp[i-1];
            }
            if(possibleTwoDigit >= 10 && possibleTwoDigit <= 26) {
                dp[i] += dp[i-2];
            }
            prev = chars[i-1];
        }
        return dp[n];
    }
}
