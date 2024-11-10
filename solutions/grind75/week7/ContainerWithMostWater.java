package solutions.grind75.week7;

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while (l < r){
            int lHeight = height[l];
            int rHeight = height[r];
            max = Math.max(max, Math.min(lHeight, rHeight) * (r - l));

            if (lHeight < rHeight) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
