package tree;

/**
 * @author : Alexander Serebriyan
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = TreeFactory.createSimpleTree();

        System.out.println(hasPathSum(root, 1));
        System.out.println(hasPathSum(root, 3));
        System.out.println(hasPathSum(root, 4));
        System.out.println(hasPathSum(root, 7));
        System.out.println(hasPathSum(root, 17));
        System.out.println(hasPathSum(root, 0));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }

    public static boolean hasPathSum(TreeNode root, int currentSum, int target) {

        if (root == null) {
            return false;
        }

        int sum = root.val + currentSum;
        if (sum == target) {
            return true;
        }

        if (sum < target) {
            return hasPathSum(root.left, sum, target) ||
                   hasPathSum(root.right, sum, target);
        }

        return false;
    }
}
