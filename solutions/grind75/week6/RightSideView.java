package solutions.grind75.week6;

import java.util.ArrayList;
import java.util.List;

import solutions.util.TreeNode;

class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        rightSideView(root, sol, 1);
        return sol;
    }

    public void rightSideView(TreeNode root, List<Integer> sol, int currDepth) {
        if (root == null) {
            return;
        }

        if (currDepth > sol.size()) {
            sol.add(root.val);
        }

        rightSideView(root.right, sol, currDepth + 1);
        rightSideView(root.left, sol, currDepth + 1);
    }
}
