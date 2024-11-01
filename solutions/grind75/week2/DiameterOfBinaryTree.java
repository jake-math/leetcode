package solutions.grind75.week2;

public class DiameterOfBinaryTree {
    
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        diameter = Math.max(diameter, left + right);
        
        return Math.max(left, right) + 1;
    }
}