package tree;

/**
 * @author : Alexander Serebriyan
 */
public class IsBinarySearchTree {

    public static void main(String[] args) {
        final Node root = new Node();
        final Node left = new Node();
        final Node right = new Node();

        root.data = 4;
        left.data = 2;
        right.data = 6;

        root.left = left;
        root.right = right;

        final Node leftLeft = new Node();
        final Node leftRight = new Node();

        leftLeft.data = 1;
        leftRight.data=3;

        left.left = leftLeft;
        left.right = leftRight;


        final Node rightLeft = new Node();
        final Node rightRight = new Node();

        rightLeft.data = 5;
        rightRight.data = 7;

        right.left = rightLeft;
        right.right = rightRight;

        System.out.println(checkBST(root));
    }

    static boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkBST(Node node, int min, int max) {

        if (node == null) {
            return true;
        }

        if (node.data > max || node.data < min) {
            return false;
        }

        final boolean leftIsBst = checkBST(node.left, min, node.data-1);
        final boolean rightIsBst = checkBST(node.right, node.data+1, max);

        return leftIsBst && rightIsBst;
    }

    static class Node {
        int data;
        Node left;
        Node right;
    }
}
