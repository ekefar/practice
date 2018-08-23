package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

/**
 * @author : Alexander Serebriyan
 */
public class Traversals {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);

        root.left = left;
        root.right = right;

        left.left = leftLeft;
        left.right = leftRight;
        right.right = rightRight;
        right.left = rightLeft;

        List<Integer> resRecursive = preorderTraversalRecursive(root);
        List<Integer> res = preorderTraversal(root);

        System.out.println(res);
        System.out.println(resRecursive);

    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        LinkedList<Integer> result = new LinkedList<>();

        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            result.add(node.val);

            if (node.right != null) {
                queue.push(node.right);
            }
            if(node.left!=null) {
                queue.push(node.left);
            }
        }

        return result;
    }


    public static List<Integer> preorderTraversalRecursive(TreeNode root) {

        LinkedList<Integer> result = new LinkedList<>();
        preorderTraversalRecursive(root, result);

        return result;
    }

    public static void preorderTraversalRecursive(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        result.add(root.val);
        preorderTraversalRecursive(root.left, result);
        preorderTraversalRecursive(root.right, result);
    }



}
