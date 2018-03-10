package design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/binary-search-tree-iterator/description/
 */


public class BSTIterator {

    private Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    private TreeNode current;

    public BSTIterator(TreeNode root) {
        addChildrenToStack(root);
        current = stack.poll();
    }

    public static void main(String[] args) {

        final TreeNode root = new TreeNode(4);
        final TreeNode left = new TreeNode(2);
        final TreeNode right = new TreeNode(7);
        final TreeNode leftLeft = new TreeNode(1);
        final TreeNode leftRight = new TreeNode(3);
        final TreeNode rightLeft = new TreeNode(6);
        final TreeNode rightRight = new TreeNode(9);

        root.left = left;
        root.right = right;

        left.left = leftLeft;
        left.right = leftRight;

        right.left = rightLeft;
        right.right = rightRight;


        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return current != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        final int value = this.current.val;

        if (current.right != null) {
            addChildrenToStack(current.right);
            current = stack.poll();
        } else {
            current = stack.poll();
        }

        return value;
    }

    private void addChildrenToStack(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode current = node;
        stack.push(node);
        while (current.left != null) {
            stack.push(current.left);
            current = current.left;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
