package tree.bst;

import tree.TreeFactory;
import tree.TreeNode;

/**
 * @author : Alexander Serebriyan
 */
public class InsertIntoBST {

    public static void main(String[] args) {
        TreeNode bst = TreeFactory.createBST();
        insertIntoBST(bst, 8);
        insertIntoBST(bst, 9);
        TreeNode treeNode = insertIntoBST(bst, 0);
        System.out.println("done");
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode current = root;

        while (current != null) {
            if (current.val > val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    current = current.left;
                }
            } else if (current.val < val) {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {
                    current = current.right;
                }
            }
        }

        return root;
    }
}
