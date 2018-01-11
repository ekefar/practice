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
        final int[] longestPath = {0};
        pathLength(root, longestPath);
        return longestPath[0];
    }

    public static int pathLength(TreeNode root, int[] longestPath) {
        if (root == null) {
            return 0;
        }

        int leftLength = pathLength(root.left, longestPath);
        int rightLength = pathLength(root.right, longestPath);
        int left = 0;
        int right = 0;
        if (root.left != null && root.left.val == root.val) {
            left = leftLength + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right = rightLength + 1;
        }

        longestPath[0] = Math.max(longestPath[0], left+right);

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
