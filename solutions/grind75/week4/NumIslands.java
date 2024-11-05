package solutions.grind75.week4;

class NumIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int sol = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    sol++;
                    dfs(i, j, grid, visited, m, n);
                }
            }
        }

        return sol;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] visited, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;

        dfs(i + 1, j, grid, visited, m, n);
        dfs(i, j + 1, grid, visited, m, n);
        dfs(i - 1, j, grid, visited, m, n);
        dfs(i, j - 1, grid, visited, m, n);
    }
}
