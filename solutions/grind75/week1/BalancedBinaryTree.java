package solutions.grind75.week1;

import java.util.HashMap;
import java.util.Map;

import solutions.util.TreeNode;

public class BalancedBinaryTree {
    Map<TreeNode, Boolean> isBalanced = new HashMap<>();
    Map<TreeNode, Integer> nodeHeight = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (isBalanced.containsKey(root)) {
            return isBalanced.get(root);
        }

        boolean result;

        if (root == null) {
            return true;
        }

        if (root.right == null && root.left == null) {
            result = true;
        } else if (root.right == null) {
            result =  getHeight(root.left) <= 1 && isBalanced(root.left);
        } else if (root.left == null) {
            result = getHeight(root.right) <= 1 && isBalanced(root.right);
        } else {
            result = Math.abs(getHeight(root.right) - getHeight(root.left)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
        }

        isBalanced.put(root, result);
        return result;
    }

    public int getHeight(TreeNode root) {
        if (nodeHeight.containsKey(root)) {
            return nodeHeight.get(root);
        }

        if (root == null) {
            nodeHeight.put(root, 0);
            return 0;
        }

        int result = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        nodeHeight.put(root, result);
        return result;
    }
}
