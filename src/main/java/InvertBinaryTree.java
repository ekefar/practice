/**
 * Created by ekefar on 4/8/17.
 * <p>
 * <p>
 * <p>
 * Invert a binary tree.
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * to
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        final TreeNode tree = prepareSample();
        printTree(tree);

        System.out.println("===");
        final TreeNode inverted = tree.invertTree(tree);
        printTree(inverted);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    private static TreeNode prepareSample() {
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

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode invertTree(TreeNode root) {

            if (root == null) {
                return root;
            }

            invertTree(root.left);
            invertTree(root.right);

            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;

            return root;
        }
    }
}


