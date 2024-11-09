package solutions.grind75.week6;

import java.util.Arrays;

class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return findPaths(0, 0, m, n, new boolean[m][n], dp);
    }

    public int findPaths(int i, int j, int m, int n, boolean[][] visited, int[][] dp) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] == -1) {
            visited[i][j] = true;
            int curr = findPaths(i + 1, j, m, n, visited, dp) + findPaths(i, j + 1, m, n, visited, dp);
            visited[i][j] = false;
            dp[i][j] = curr;
            return curr;
        } else {
            return dp[i][j];
        }
    }
}