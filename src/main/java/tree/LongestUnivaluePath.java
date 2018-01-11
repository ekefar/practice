package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author : Alexander Serebriyan
 *
 * https://leetcode.com/problems/longest-univalue-path/description/
 */
public class LongestUnivaluePath {

    static int longestPath = 0;

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(4);
        final TreeNode right = new TreeNode(5);
        final TreeNode left = new TreeNode(5);
        final TreeNode leftLeft = new TreeNode(5);
        final TreeNode rightRight = new TreeNode(5);

//        root.left = left;
        root.right = right;
        right.right = rightRight;
//        left.left = leftLeft;

        System.out.println(longestUnivaluePath(root));
    }

    public static int longestUnivaluePath(TreeNode root) {
        pathLength(root);
        return longestPath;
    }

    public static int pathLength(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = pathLength(root.left);
        int rightLength = pathLength(root.right);
        int left = 0;
        int right = 0;
        if (root.left != null && root.left.val == root.val) {
            left = leftLength + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right = rightLength + 1;
        }

        longestPath = Math.max(longestPath, left+right);

        return Math.max(left, right);

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
