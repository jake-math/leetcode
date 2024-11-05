package solutions.grind75.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import solutions.util.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> sol = new ArrayList<>();

        if (root == null) {
            return sol;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < queueSize; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);

                temp.add(queue.poll().val);
            }

            sol.add(temp);
        }

        return sol;
    }


}
