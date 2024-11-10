package solutions.grind75.week8;

import solutions.util.TreeNode;

public class SerializeBST {

    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        dfs(root, result);
        System.out.println(result.toString());
        return result.toString();
    }

    private void dfs(TreeNode root, StringBuilder sol) {
        if (root == null) {
            sol.append("#");
            return;
        }
        
        sol.append(root.val).append("l");
        dfs(root.left, sol);
        
        sol.append("r");
        dfs(root.right, sol);
    }


    public TreeNode deserialize(String data) {
        Index index = new Index();
        return dfsDeserialize(data, index);
    }

    private static class Index {
        int value = 0;
    }

    private TreeNode dfsDeserialize(String data, Index index) {
        if (index.value >= data.length()) return null;

        if (data.charAt(index.value) == '#') {
            index.value++;
            return null;
        }

        StringBuilder num = new StringBuilder();
        while (Character.isDigit(data.charAt(index.value)) || data.charAt(index.value) == '-') {
            num.append(data.charAt(index.value++));
        }
        TreeNode root = new TreeNode(Integer.parseInt(num.toString()));

        if (index.value < data.length() && data.charAt(index.value) == 'l') {
            index.value++;
            root.left = dfsDeserialize(data, index);
        }

        if (index.value < data.length() && data.charAt(index.value) == 'r') {
            index.value++;
            root.right = dfsDeserialize(data, index);
        }

        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
