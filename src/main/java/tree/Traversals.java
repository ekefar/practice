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



        System.out.println(preorderTraversalRecursive(root));
        System.out.println(preorderTraversal(root));

        System.out.println(inorderTraversalRecursive(root));

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

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {

        LinkedList<Integer> result = new LinkedList<>();
        inorderTraversalRecursive(root, result);

        return result;
    }

    public static void inorderTraversalRecursive(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        inorderTraversalRecursive(root.left, result);
        result.add(root.val);
        inorderTraversalRecursive(root.right, result);
    }



}
