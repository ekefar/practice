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
        TreeNode root = TreeFactory.getSimpleTree();


        System.out.println(preorderTraversalRecursive(root));
        System.out.println(preorderTraversal(root));

        System.out.println(inorderTraversalRecursive(root));

        System.out.println(levelTraversal(root));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        LinkedList<Integer> result = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if(node.left!=null) {
                stack.push(node.left);
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

    public static List<Integer> levelTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.pollFirst();
            result.add(node.val);
            if(node.left != null) {
                queue.add(node.left);
            }

            if(node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }


}
