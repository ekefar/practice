package general;

import java.util.Stack;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }
        final char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        try {
            for (char aChar : chars) {
                if (aChar == '(' || aChar == '[' || aChar == '{') {
                    stack.push(aChar);
                } else if (aChar == ')' && stack.pop() != '(') {
                    return false;
                } else if (aChar == ']' && stack.pop() != '[') {
                    return false;
                } else if (aChar == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return stack.isEmpty();
    }
}
