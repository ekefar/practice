package tree;

/**
 * @author : Alexander Serebriyan
 */
public class TreeFactory {

    public static TreeNode getSimpleTree() {
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

        return root;
    }
}
