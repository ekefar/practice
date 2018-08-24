package tree;

/**
 * @author : Alexander Serebriyan
 */
public class TreeDepth {


    public static void main(String[] args) {
        TreeNode root = TreeFactory.getSimpleTree();

        System.out.println(maxDepth(root));
        System.out.println(maxDepth(root.left));
        System.out.println(maxDepth(root.left.left));
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }


}
