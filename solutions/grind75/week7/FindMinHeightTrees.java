package solutions.grind75.week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        Map<Integer, Integer> nodeToMinHeight = new HashMap<>();
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];

            Node firstNode = nodes[first];
            Node secondNode = nodes[second];

            firstNode.neighbors.add(secondNode);
            secondNode.neighbors.add(firstNode);
        }

        for (Node node : nodes) {
            boolean[] visited = new boolean[n];
            nodeToMinHeight.put(node.val, dfs(node, visited));
        }

        List<Integer> sol = new ArrayList<>();
        int minHeight = Collections.min(nodeToMinHeight.values());

        for (Map.Entry<Integer, Integer> nodeToHeight : nodeToMinHeight.entrySet()) {
            Integer key = nodeToHeight.getKey();
            Integer value = nodeToHeight.getValue();
            if (value == minHeight) sol.add(key);
        }  

        return sol;
    }

    public int dfs(Node node, boolean[] visited) {
        visited[node.val] = true;
        
        int height = 0;
        for (Node neighbor : node.neighbors) {
            if (!visited[neighbor.val]) {
                height = Math.max(height, dfs(neighbor, visited) + 1);
            }
        }
        
        visited[node.val] = false;
        return height;
    }

    public class Node {
        List<Node> neighbors;
        int val;

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }
}
