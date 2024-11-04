package solutions.grind75.week3;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Map<Node,Node> map= new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        map.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            Node clone = map.get(curr);

            for (Node neighbor : curr.neighbors) {
                
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }

                Node neighborClone = map.get(neighbor);
                clone.neighbors.add(neighborClone);
            }
        }

        
        return map.get(node);

    }
}