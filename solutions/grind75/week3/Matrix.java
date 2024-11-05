package solutions.grind75.week3;

class Matrix {

    private int m;
    private int n;

    public int[][] updateMatrix(int[][] mat) {
        this.m = mat.length;
        this.n = mat[0].length;

        int[][] sol = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                sol[i][j] = dfs(mat, i, j, visited);
            }
        }

        return sol;
    }

    public int dfs(int[][] mat, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return Integer.MAX_VALUE;  // Out of bounds or already visited
        }
        
        if (mat[i][j] == 0) {
            return 0;  // We've found a zero, no need to go further
        }

        visited[i][j] = true;
        
        // Explore in all 4 directions and find the minimum distance to a zero
        int left = dfs(mat, i, j - 1, visited);
        int right = dfs(mat, i, j + 1, visited);
        int up = dfs(mat, i - 1, j, visited);
        int down = dfs(mat, i + 1, j, visited);

        visited[i][j] = false;  // Backtrack
        
        // Return the minimum distance found in all directions plus 1 step
        return 1 + Math.min(Math.min(left, right), Math.min(up, down));
    }
}
