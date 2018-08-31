package lists;

import java.util.List;

/**
 * @author : Alexander Serebriyan
 */
public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();


//["MyLinkedList","addAtHead","addAtIndex","get","get","get"]
//[[],[1],[1,2],[1],[0],[2]]

        list.addAtHead(1);
        list.addAtIndex(1,2);
        System.out.println(list.get(1));
        System.out.println(list.get(0));
        System.out.println(list.get(2));

        list.addAtIndex(1,5);
        list.addAtTail(7);
        list.addAtHead(1);
        list.addAtIndex(5,8);
        list.addAtIndex(5,2);
        list.addAtIndex(3,0);
        list.addAtTail(1);
        list.addAtTail(0);
        list.deleteAtIndex(6);

//        ================
        list.addAtHead(10);
        list.addAtTail(1);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println();

        list.deleteAtIndex(0);
        list.deleteAtIndex(0);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println();

        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println();

        list.addAtHead(-1);
        list.addAtHead(-2);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println();

        list.deleteAtIndex(0);
        list.deleteAtIndex(3);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println();

        list.addAtIndex(1, 0);
        list.addAtIndex(0, -2);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println();

    }

    private ListNode head;
    private ListNode tail;
    private int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        ListNode dummy = new ListNode(0);
        head = dummy;
        tail = dummy;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        return getNodeAtIndex(index).val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if(index>size) {
            return;
        } else if(index==size) {
            addAtTail(val);
            return;
        }
        ListNode nodeAtIndex = getNodeAtIndex(index - 1);

        ListNode newNode = new ListNode(val);
        newNode.next = nodeAtIndex.next;
        nodeAtIndex.next = newNode;
        size++;
    }

    private ListNode getNodeAtIndex(int index) {
        ListNode nodeAtIndex = head;

        for (int i = 0; i <= index; i++) {
            nodeAtIndex = nodeAtIndex.next;
        }
        return nodeAtIndex;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        ListNode nodeBeforeIndex = getNodeAtIndex(index - 1);
        nodeBeforeIndex.next = nodeBeforeIndex.next.next;

        if (index == size - 1) {
            tail = nodeBeforeIndex;
        }

        size--;
    }


}
