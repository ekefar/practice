package lists;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        final ListNode a = new ListNode(1);
        final ListNode b = new ListNode(2);
        a.next = b;

        final ListNode listNode = reverseList(a);
        System.out.println(listNode);
    }


    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode previous = head;
        ListNode current = head.next;
        previous.next = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

}
