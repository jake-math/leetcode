package solutions.grind75.week1;

import javax.swing.tree.TreeNode;

public class LowestCommonAncestorBST {
    private TreeNode lca = new TreeNode();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        checkTree(root, p, q);
        return lca;
    }

    public void checkTree(TreeNode root, TreeNode p, TreeNode q) {
        lca = root;
        
        if (root == p && (contains(root.right, q) || contains(root.left, q))) {
            return;
        } else if (root == q && (contains(root.right, p) || contains(root.left, p))) {
            return;
        } else {
            if (contains(root.right, p) && contains(root.right, q)) {
                checkTree(root.right, p, q);
            } else if (contains(root.left, p) && contains(root.left, q)) {
                checkTree(root.left, p, q);
            } else {
                return;
            }
        }
    }

    public boolean contains(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        
        if (root == node) {
            return true;
        }

        return contains(root.left, node) || contains(root.right, node);
    }
}
