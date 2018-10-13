package tree;

/**
 * @author : Alexander Serebriyan
 */
public class TreeDepth {


    public static void main(String[] args) {
        TreeNode root = TreeFactory.createSimpleTree();

        System.out.println(maxDepth(root));
        System.out.println(maxDepth(root.left));
        System.out.println(maxDepth(root.left.left));
    }


    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
