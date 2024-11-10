package solutions.grind75.week1;

import solutions.util.TreeNode;

class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode invertRight = invertTree(root.right);
        TreeNode invertLeft = invertTree(root.left);

        root.right = invertLeft;
        root.left = invertRight;

        return root;
    }
}
