package strings;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.com/problems/invert-binary-tree/#/description
 *
 * Given s = "hello", return "olleh".
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseString("abcdefg"));
        System.out.println(reverseStringUsingArray("abcdefg"));
    }

    public static String reverseString(String s) {
        final StringBuilder stringBuilder = new StringBuilder();

        for(int i = s.length()-1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static String reverseStringUsingArray(String s) {
        final int length = s.length();
        final char[] chars = s.toCharArray();

        for (int i = 0; i < length/2; i++) {
            final char temp = chars[i];
            final int otherCharIndex = length - i - 1;
            chars[i] = chars[otherCharIndex];
            chars[otherCharIndex] = temp;
        }

        return new String(chars);
    }
}
