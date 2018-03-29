package strings;

import java.util.Arrays;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("anana"));
        System.out.println(longestPalindrome("baaaabb"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("c"));
    }

    public static String longestPalindrome(String s) {
        if(s.length() <= 2) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String  odd = extractPalindrome(s, i, i);
            String even = extractPalindrome(s, i, i + 1);

            String max = odd.length() > even.length() ? odd:even;

            if(max.length() > result.length()) {
                result = max;
            }
        }
        return result;

    }

    public static String extractPalindrome(String str, int left, int right) {
        while(left >= 0 && right < str.length() &&
                str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return str.substring( left+1, right);
    }
}
