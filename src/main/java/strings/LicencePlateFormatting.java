package strings;

import arrays.LeftRotation;

import java.util.Arrays;

/**
 * @author : Alexander Serebriyan
 *         <p>
 *         https://leetcode.com/problems/license-key-formatting/description/
 *         <p>
 *         You are given a license key represented as a string S which consists only alphanumeric character and dashes.
 *         The string is separated into N+1 groups by N dashes.
 *         <p>
 *         Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except
 *         for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must
 *         be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 *         <p>
 *         Given a non-empty string S and a number K, format the string according to the rules described above.
 *         <p>
 *         Example 1:
 *         Input: S = "5F3Z-2e-9-w", K = 4
 *         <p>
 *         Output: "5F3Z-2E9W"
 *         <p>
 *         Explanation: The string S has been split into two parts, each part has 4 characters.
 *         Note that the two extra dashes are not needed and can be removed.
 *         Example 2:
 *         Input: S = "2-5g-3-J", K = 2
 *         <p>
 *         Output: "2-5G-3J"
 *         <p>
 *         Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could
 *         be shorter as mentioned above.
 */
public class LicencePlateFormatting {

    public static void main(String[] args) {
//        System.out.println(licenseKeyFormatting("aaa", 1));
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
//        System.out.println(licenseKeyFormatting("a0001afds-", 4));
    }

    public static String licenseKeyFormatting(String S, int K) {
        final String noDashes = S.replaceAll("-", "");

        final char[] chars = noDashes.toCharArray();
        final int leadingPartSize = chars.length % K;
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];

            if (i > 0 && (i == leadingPartSize || (i - leadingPartSize) % K == 0)) {
                builder.append("-");
            }
            builder.append(aChar);


        }


        return builder.toString().toUpperCase();
    }
}