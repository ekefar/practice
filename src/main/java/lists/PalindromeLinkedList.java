package lists;

import java.util.Stack;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    /* O(1) space solution would be to have slow-fast pointers, reverse half of
     the list and then compare two lists */
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        int size = getSize(head);

        if (size == 1) {
            return true;
        }

        ListNode current = head;
        for(int i=0; i<size/2;i++) {
            stack.push(current.val);
            current = current.next;
        }

        if (size % 2 != 0) {
            current = current.next;
        }

        while (!stack.isEmpty()) {
            Integer val = stack.pop();

            if(current.val != val) {
                return false;
            }

            current = current.next;
        }

        return current == null;
    }

    private static int getSize(ListNode head) {
        int size = 0;

        ListNode current = head;

        while (current!= null) {
            current = current.next;
            size++;
        }

        return size;
    }
}
