package solutions.grind75.week1;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, image[sr][sc], color, new boolean[image.length][image[0].length]);
        return image;
    }

    public void fill(int[][] image, int i, int j, int src, int color, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || visited[i][j] || image[i][j] != src) {
            return;
        }

        if (image[i][j] == src) {
            image[i][j] = color;
        }

        visited[i][j] = true;

        fill(image, i + 1, j, src, color, visited);
        fill(image, i, j + 1, src, color, visited);
        fill(image, i - 1, j, src, color, visited);
        fill(image, i, j - 1, src, color, visited);
    }
}
