package lists;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Alexander Serebriyan
 *         https://www.hackerrank.com/challenges/ctci-linked-list-cycle
 */
public class HasCycle {

    boolean hasCycle(Node head) {
        Node current = head;
        Map<Node, Boolean> map = new HashMap<>();
        while (current != null) {
            if (map.containsKey(current)) {
                return true;
            }

            map.put(current, true);

            current = current.next;
        }

        return false;
    }

    boolean hasCycleFastSlow(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    class Node {
        int data;
        Node next;
    }
}
