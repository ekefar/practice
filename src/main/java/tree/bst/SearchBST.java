package tree.bst;

import tree.TreeFactory;
import tree.TreeNode;

/**
 * @author : Alexander Serebriyan
 */
public class SearchBST {

    public static void main(String[] args) {
        TreeNode bst = TreeFactory.createBST();

        System.out.println(searchBST(bst, 5));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root==null) {
            return null;
        }

        if(root.val == val) {
            return root;
        }

        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
