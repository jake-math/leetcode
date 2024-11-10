package solutions.grind75.week7;

class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (dfs(board, visited, i, j, m, n, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, int i, int j, int m, int n, String target, int index) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != target.charAt(index)) {
            return false;
        }

        if (index == target.length() - 1) {
            return true;
        }

        visited[i][j] = true;

        boolean result = dfs(board, visited, i + 1, j, m, n, target, index + 1) || 
                         dfs(board, visited, i - 1, j, m, n, target, index + 1) || 
                         dfs(board, visited, i, j + 1, m, n, target, index + 1) || 
                         dfs(board, visited, i, j - 1, m, n, target, index + 1);

        visited[i][j] = false;

        return result;
    }
}
