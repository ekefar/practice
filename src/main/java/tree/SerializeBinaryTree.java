package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Alexander Serebriyan
 */
public class SerializeBinaryTree {

    public static void main(String[] args) {

        String serialize = serialize(null);
        System.out.println(serialize);
        TreeNode tree = deserialize(serialize);
        System.out.println(tree);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                builder.append("null");
            } else {
                builder.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }

            builder.append(",");
        }

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {


        String[] split = data.split(",");

        Queue<String> queueStrings = new LinkedList<>();
        Queue<TreeNode> queueNodes = new LinkedList<>();

        Collections.addAll(queueStrings, split);

        String rootString = queueStrings.poll();

        if("null".equals(rootString)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(rootString));

        queueNodes.add(root);

        while (!queueNodes.isEmpty() && !queueStrings.isEmpty()) {
            TreeNode node = queueNodes.poll();

            if(node==null) {
                continue;
            }

            String left = queueStrings.poll();
            String right = queueStrings.poll();
            node.left = "null".equals(left) ? null: new TreeNode(Integer.valueOf(left));
            node.right = "null".equals(right) ? null: new TreeNode(Integer.valueOf(right));

            queueNodes.add(node.left);
            queueNodes.add(node.right);
        }
        return root;
    }
}
