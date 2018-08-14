package lists;

import java.util.List;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
//        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode res = addTwoNumbers(listNode1, listNode4);
        System.out.println(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode previousNode = new ListNode(0);
        ListNode currentNode = new ListNode(0);
        ListNode res = previousNode;
        int remainder = 0;


        boolean firstNode = true;
        while (l1 != null || l2 != null) {

            int val1 = 0;
            int val2 = 0;

            if(l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int sum = val1 + val2 + remainder;
            remainder = sum / 10;
            System.out.println(sum%10);
            currentNode = new ListNode(sum % 10);
            previousNode.next = currentNode;
            previousNode = currentNode;

            if(firstNode) {
                res = currentNode;
                firstNode = false;
            }
        }

        if(remainder != 0) {
            currentNode.next = new ListNode(1);
        }

        return res;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
