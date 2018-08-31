package lists;

/**
 * @author : Alexander Serebriyan
 */
public class LinkedListsIntersection {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);

        int offset = Math.abs(sizeA - sizeB);

        return sizeA > sizeB ? getIntersection(headA, headB, offset) : getIntersection(headB, headA, offset);
    }

    private ListNode getIntersection(ListNode large, ListNode small, int offset) {

        while (offset != 0) {
            large = large.next;
            offset--;
        }

        while (large != null && small != null) {
            if (large == small) {
                return large;
            }

            large = large.next;
            small = small.next;
        }

        return null;
    }


    private int getSize(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            size++;
        }

        return size;
    }
}
